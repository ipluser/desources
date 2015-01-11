package org.mana.resource;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mana.resource.OutputStreamResource;

/**
 * @author pluser
 * @version 0.5 2014/12/2
 */
public class TestOutputStreamResource {

	private static OutputStreamResource resource;
	
	@BeforeClass
	public static void before() throws Exception {
		resource = new OutputStreamResource(new BufferedOutputStream(
				new FileOutputStream(new File("D:/tempFile.txt"))));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorByNull() {
		new OutputStreamResource(null);
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
				+ "]");
		
		OutputStream os = resource.getOutputStream();
		try {
			Assert.assertNotNull(os);
		} finally {
			os.close();
		}
	}
	
	@Test(expected = IOException.class)
	public void testInputStream() throws Exception {
		resource.getInputStream();
	}
}
