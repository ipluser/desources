package org.desources.core;

/**
 * @author pluser
 * @version 0.5 2015/1/4
 */
public interface ResourceLoader {
	
	public Resource getResource(String location);
	
	public ClassLoader getClassLoader();
}
