package org.mana.resource;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mana.resource.ByteArrayResource;

/**
 * @author pluser
 * @version 0.5 2014/11/25
 */
public class TestByteArrayResource {

	private static final byte[] byteArray = "测试ByteArrayResource".getBytes();
	private static ByteArrayResource resource;
	
	@BeforeClass
	public static void before() throws Exception {
		resource = new ByteArrayResource(byteArray);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorByNullByteArray() {
		new ByteArrayResource(null);
	}
	
	@Test
	public void testFunction() throws Exception {
		System.out.println("testFunction: "
				+ "byteArray[" + resource.getByteArray() 
				+ "], name[" + resource.getName()
				+ "], description[" + resource.getDescription()
				+ "], size[" + resource.size()
				+ "]");
	}
	
	@Test
	public void testInputStream() throws Exception {
		InputStream is = resource.getInputStream();
		try {
			Assert.assertNotNull(is);
		} finally {
			is.close();
		}
	}
	
	@Test(expected = IOException.class)
	public void testOutputStream() throws Exception {
		resource.getOutputStream();
	}
	
	@Test
	public void testHashCodeNotEqual() throws Exception {
		ByteArrayResource cmpResource = new ByteArrayResource("测试ByteArrayResource2".getBytes());
		Assert.assertTrue(!resource.equals(cmpResource));
	}
	
	@Test
	public void testHashCodeEqual() throws Exception {
		ByteArrayResource cmpResource = new ByteArrayResource("测试ByteArrayResource".getBytes());
		Assert.assertTrue(resource.equals(cmpResource));
	}
}
