package org.desources.core;

/**
 * @author pluser
 * @version 0.5 2015/1/4
 */
public class ClassRelativeResourceLoader extends DefaultResourceLoader {
	
	private final Class<?> clazz;
	
	public ClassRelativeResourceLoader(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	public ClassRelativeResourceLoader(ClassLoader classLoader, Class<?> clazz) {
		super(classLoader);
		this.clazz = clazz;
	}
	
	@Override
	protected Resource getResourceByPath(String path) {
		return new ClassPathResource(path, getClassLoader(), clazz);
	}
}
