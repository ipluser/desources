package org.mana.resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.mana.resource.util.AssertUtil;
import org.mana.resource.util.ClassUtil;

/**
 * @author pluser
 * @version 0.5 2014/12/8
 */
public class ClassPathResource extends AbstractResource {

	protected static final String FOLDER_SEPARATOR = "/";
	
	private final String path;
	
	private ClassLoader classLoader;
	private Class<?> clazz;
	
	/**
	 * 
	 * @param path the absolute path within the classpath
	 */
	public ClassPathResource(String path) {
		this(path, null, null);
	}
	
	/**
	 * 
	 * @param path the absolute path within the classpath
	 * @param classLoader the class loader to load the resource with, or null for the thread context class loader
	 */
	public ClassPathResource(String path, ClassLoader classLoader) {
		this(path, classLoader, null);
	}
	
	/**
	 * 
	 * @param path relative or absolute path within the class path
	 * @param clazz the class to load resources with
	 */
	public ClassPathResource(String path, Class<?> clazz) {		
		this(path, null, clazz);
	}
	
	/**
	 * 
	 * @param path relative or absolute path within the class path
	 * @param classLoader the class loader to load the resource with, or null for the thread context class loader
	 * @param clazz the class to load resources with
	 */
	public ClassPathResource(String path, ClassLoader classLoader, Class<?> clazz) {
		AssertUtil.notNull(path, "path must not be null");
		
		this.path = path;
		this.classLoader = (classLoader == null) ? ClassUtil.getDefaultClassLoader() : classLoader;
		this.clazz = clazz;
	}

	public String getPath() {
		return path;
	}
	
	public ClassLoader getClassLoader() {
		return classLoader != null ? classLoader : clazz.getClassLoader();
	}
	
	@Override
	public String getName() {
		int index = path.lastIndexOf(FOLDER_SEPARATOR);
		return (index != -1 ? path.substring(index + 1) : path);
	}
	
	@Override
	public String getDescription() {
		return "resource loaded from classPath [" + path + "]";
	}
	
	@Override
	public boolean isWritable() {
		return false;
	}
	
	@Override
	public boolean exists() {
		URL url = null;
		if (clazz != null) {
			url = clazz.getResource(path);
		} 
		
		if (url == null && classLoader != null) {
			url = classLoader.getResource(path);
		}
		
		return url != null;
	}
	
	@Override
	public URL getUrl() throws IOException {
		URL url = null;
		if (clazz != null) {
			url = clazz.getResource(path);
		}
		
		if (url == null && classLoader != null) {
			url = classLoader.getResource(path);
		}
		
		if (url == null) {
			throw new FileNotFoundException(getName() 
					+ " that cannot be resolved to URL");
		}
		
		return url;
	}
	
	@Override
	public InputStream getInputStream() throws IOException {
		InputStream inputStream = null;
		if (clazz != null) {
			inputStream = clazz.getResourceAsStream(path);
		}
		
		if (inputStream == null && classLoader != null) {
			inputStream = classLoader.getResourceAsStream(path);
		}
		
		if (inputStream == null) {
			throw new IOException("InputStream not supported");
		}
		
		return inputStream;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj == this) {
			return true;
		}
		
		if (obj instanceof ClassPathResource 
				&& ((ClassPathResource) obj).path.equals(this.path)
				&& ((ClassPathResource) obj).classLoader.equals(this.classLoader)) {
			Class<?> compareClazz = ((ClassPathResource) obj).clazz;
			if (compareClazz == clazz || 
					(compareClazz != null && clazz != null && compareClazz.equals(clazz))) {
				return true;
			}
		}
		
		return true;
	}

	@Override
	public int hashCode() {
		return path.hashCode();
	}
}
