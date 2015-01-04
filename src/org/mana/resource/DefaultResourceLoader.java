package org.mana.resource;

import java.net.MalformedURLException;
import java.net.URL;

import org.mana.resource.util.ClassUtil;
/**
 * @author pluser
 * @version 0.5 2015/1/4
 */
public class DefaultResourceLoader implements ResourceLoader {

	private ClassLoader classLoader;
	
	public DefaultResourceLoader() {
		this.classLoader = ClassUtil.getDefaultClassLoader();
	}
	
	public DefaultResourceLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}
	
	public void setClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}
	
	@Override
	public Resource getResource(String location) {
		if (location == null) {
			throw new IllegalArgumentException("location must not be null");
		}
		
		if (location.startsWith(CLASSPATH_URL_PREFIX)) {
			return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()), 
					getClassLoader());
		} else {
			try {
				URL url = new URL(location);
				return new UrlResource(url);
			} catch (MalformedURLException ex) {
				return getResourceByPath(location);
			}
		}
	}

	@Override
	public ClassLoader getClassLoader() {
		return (classLoader != null ? classLoader : ClassUtil.getDefaultClassLoader());
	}
	
	protected Resource getResourceByPath(String path) {
		return new FileResource(path);
	}
}
