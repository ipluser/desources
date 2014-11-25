package org.mana.core.io;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author pluser
 * @version 0.5 2014/11/25
 */
public class TestByteArrayResource {

	private final byte[] byteArray = "测试ByteArrayResource".getBytes();
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorByNullByteArray() {
		new ByteArrayResource(null);
	}
	
	@Test
	public void testFunctionByByteArray() throws Exception {
		ByteArrayResource byteArrayResource = new ByteArrayResource(byteArray);
		System.out.println("testFunctionByByteArray: "
				+ "byteArray[" + byteArrayResource.getByteArray() 
				+ "], name[" + byteArrayResource.getName()
				+ "], description[" + byteArrayResource.getDescription()
				+ "], size[" + byteArrayResource.size()
				+ "]");
	}
	
	@Test
	public void testInputStreamByByteArray() throws Exception {
		ByteArrayResource byteArrayResource = new ByteArrayResource(byteArray);
		InputStream is = byteArrayResource.getInputStream();
		try {
			Assert.assertNotNull(is);
		} finally {
			is.close();
		}
	}
	
	@Test(expected = IOException.class)
	public void testOutputStreamByFile() throws Exception {
		ByteArrayResource byteArrayResource = new ByteArrayResource(byteArray);
		byteArrayResource.getOutputStream();
	}
	
	@Test
	public void testHashCodeNotEqual() throws Exception {
		ByteArrayResource bar1 = new ByteArrayResource(byteArray);
		ByteArrayResource bar2 = new ByteArrayResource("测试ByteArrayResource2".getBytes());
		Assert.assertTrue(!bar1.equals(bar2));
	}
	
	@Test
	public void testHashCodeEqual() throws Exception {
		ByteArrayResource bar1 = new ByteArrayResource(byteArray);
		ByteArrayResource bar2 = new ByteArrayResource("测试ByteArrayResource".getBytes());
		Assert.assertTrue(bar1.equals(bar2));
	}
}
