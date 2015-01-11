package org.mana.resource.util;

/**
 * @author pluser
 * @version 0.5 2015/1/11
 */
public abstract class AssertUtil {

	public static void notNull(Object obj) {
		notNull(obj, "Argument must not be null");
	}
	
	public static void notNull(Object obj, String msg) {
		if (obj == null) {
			throw new IllegalArgumentException(msg);
		}
	}
}
