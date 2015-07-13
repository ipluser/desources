package org.desources.core.util;

/**
 * @author pluser
 * @version 0.5 2015/1/4
 */
public abstract class ClassUtil {

	public static final String CLASSPATH_URL_PREFIX = "classpath:";
	
	public static ClassLoader getDefaultClassLoader() {
		ClassLoader defaultClassLoader = null;
		try {
			defaultClassLoader = Thread.currentThread().getContextClassLoader();
		} catch (Throwable t) {
		}
		
		if (defaultClassLoader == null) {
			defaultClassLoader = ClassUtil.class.getClassLoader();
		}
		
		return defaultClassLoader;
	}
}
