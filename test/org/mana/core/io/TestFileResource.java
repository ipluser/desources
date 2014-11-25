package org.mana.core.io;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author pluser
 * @version 0.5 2014/11/22
 */
public class TestFileResource {

	private File file = new File("D:/tempFile.txt");
	private String absolutePath = "D:/tempPath.txt";
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorByNullFile() {
		File tempFile = null;
		new FileResource(tempFile);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorByNullPath() {
		String path = null;
		new FileResource(path);
	}
	
	@Test
	public void testFunctionByFile() throws Exception {
		FileResource fileResource = new FileResource(file);
		System.out.println("testFunctionByFile: "
				+ "name[" + fileResource.getName()
				+ "], desc[" + fileResource.getDescription()
				+ "], path[" + fileResource.getPath()
				+ "], uri[" + fileResource.getUri()
				+ "], url[" + fileResource.getUrl()
				+ "], exists[" + fileResource.exists()
				+ "], isOpen[" + fileResource.isOpen()
				+ "], isReadale[" + fileResource.isReadable()
				+ "], isWritable[" + fileResource.isWritable()
				+ "], size[" + fileResource.size()
				+ "], lastModified[" + fileResource.lastModified()
				+ "]");
	}
	
	@Test
	public void testFunctionByAbsolutePath() throws Exception {
		FileResource fileResource = new FileResource(absolutePath);
		System.out.println("testFunctionByAbsolutePath: "
				+ "name[" + fileResource.getName()
				+ "], desc[" + fileResource.getDescription()
				+ "], path[" + fileResource.getPath()
				+ "], uri[" + fileResource.getUri()
				+ "], url[" + fileResource.getUrl()
				+ "], exists[" + fileResource.exists()
				+ "], isOpen[" + fileResource.isOpen()
				+ "], isReadale[" + fileResource.isReadable()
				+ "], isWritable[" + fileResource.isWritable()
				+ "], size[" + fileResource.size()
				+ "], lastModified[" + fileResource.lastModified()
				+ "]");
	}
	
	@Test
	public void testInputStreamByFile() throws Exception {
		FileResource fileResource = new FileResource(file);
		InputStream is = fileResource.getInputStream();
		try {
			Assert.assertNotNull(is);
		} finally {
			is.close();
		}
	}
	
	@Test
	public void testInputStreamByAbsolutePath() throws Exception {
		FileResource fileResource = new FileResource(absolutePath);
		InputStream is = fileResource.getInputStream();
		try {
			Assert.assertNotNull(is);
		} finally {
			is.close();
		}
	}
	
	@Test
	public void testOutputStreamByFile() throws Exception {
		FileResource fileResource = new FileResource(file);
		OutputStream os = fileResource.getOutputStream();
		try {
			Assert.assertNotNull(os);
		} finally {
			os.close();
		}
	}
	
	@Test
	public void testOutputStreamByAbsolutePath() throws Exception {
		FileResource fileResource = new FileResource(absolutePath);
		OutputStream os = fileResource.getOutputStream();
		try {
			Assert.assertNotNull(os);
		} finally {
			os.close();
		}
	}
}
