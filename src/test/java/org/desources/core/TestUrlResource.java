package org.desources.core;

import java.io.InputStream;
import java.net.URL;

import org.desources.core.UrlResource;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author pluser
 * @version 0.5 2014/12/4
 */
public class TestUrlResource {

	private static UrlResource resource;
	
	@BeforeClass
	public static void before() throws Exception {
		resource = new UrlResource(
				new URL("https://avatars3.githubusercontent.com/u/9295121?v=3&s=460"));
	}
	
	@Test
	public void testFunctionByValidURL() throws Exception {
		System.out.println("testFunction: "
				+ "desc[" + resource.getDescription()
				+ "], size[" + resource.size()
				+ "]");
		
		InputStream is = resource.getInputStream();
		try {
			Assert.assertNotNull(is);
		} finally {
			is.close();
		}
	}
	
}
