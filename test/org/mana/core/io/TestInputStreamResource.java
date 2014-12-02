package org.mana.core.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author pluser
 * @version 0.5 2014/12/2
 */
public class TestInputStreamResource {

	private static InputStreamResource resource;
	
	@BeforeClass
	public static void before() throws Exception {
		resource = new InputStreamResource(new BufferedInputStream(
				new FileInputStream(new File("D:/tempFile.txt"))));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorByNull() {
		new InputStreamResource(null);
	}
	
	@Test
	public void testFunction() throws Exception {
		System.out.println("testFunction: "
				+ "name[" + resource.getName()
				+ "], desc[" + resource.getDescription()
				+ "], exists[" + resource.exists()
				+ "], isOpen[" + resource.isOpen()
				+ "], isReadale[" + resource.isReadable()
				+ "], isWritable[" + resource.isWritable()
				+ "], size[" + resource.size()
				+ "]");
		
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
}
