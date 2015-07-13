package org.desources.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.desources.core.util.AssertUtil;
import org.desources.core.util.ClassUtil;
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
		AssertUtil.notNull(location, "location must not be null");
		
		if (location.startsWith(ClassUtil.CLASSPATH_URL_PREFIX)) {
			return new ClassPathResource(location.substring(
					ClassUtil.CLASSPATH_URL_PREFIX.length()), getClassLoader());
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
