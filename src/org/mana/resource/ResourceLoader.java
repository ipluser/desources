package org.mana.resource;

/**
 * @author pluser
 * @version 0.5 2015/1/4
 */
public interface ResourceLoader {

	public static final String CLASSPATH_URL_PREFIX = "classpath:";
	
	public Resource getResource(String location);
	
	public ClassLoader getClassLoader();
}
