package org.mana.core.io;

import java.io.InputStream;
import java.net.URL;

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
				new URL("http://www.oschina.net/img/logo_s2.png"));
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
