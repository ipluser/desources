package org.mana.resource;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mana.resource.FileResource;

/**
 * @author pluser
 * @version 0.5 2014/11/22
 */
public class TestFileResource {

	private static FileResource fRscByFile;
	private static FileResource fRscByPath;
	
	@BeforeClass
	public static void before() throws Exception {
		fRscByFile = new FileResource(new File("D:/tempFile.txt"));
		fRscByPath = new FileResource("D:/tempPath.txt");
	}
	
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
		System.out.println("testFunctionByFile: "
				+ "name[" + fRscByFile.getName()
				+ "], desc[" + fRscByFile.getDescription()
				+ "], path[" + fRscByFile.getPath()
				+ "], uri[" + fRscByFile.getUri()
				+ "], url[" + fRscByFile.getUrl()
				+ "], exists[" + fRscByFile.exists()
				+ "], isOpen[" + fRscByFile.isOpen()
				+ "], isReadale[" + fRscByFile.isReadable()
				+ "], isWritable[" + fRscByFile.isWritable()
				+ "], size[" + fRscByFile.size()
				+ "], lastModified[" + fRscByFile.lastModified()
				+ "]");
	}
	
	@Test
	public void testFunctionByAbsolutePath() throws Exception {
		System.out.println("testFunctionByAbsolutePath: "
				+ "name[" + fRscByPath.getName()
				+ "], desc[" + fRscByPath.getDescription()
				+ "], path[" + fRscByPath.getPath()
				+ "], uri[" + fRscByPath.getUri()
				+ "], url[" + fRscByPath.getUrl()
				+ "], exists[" + fRscByPath.exists()
				+ "], isOpen[" + fRscByPath.isOpen()
				+ "], isReadale[" + fRscByPath.isReadable()
				+ "], isWritable[" + fRscByPath.isWritable()
				+ "], size[" + fRscByPath.size()
				+ "], lastModified[" + fRscByPath.lastModified()
				+ "]");
	}
	
	@Test
	public void testInputStreamByFile() throws Exception {
		InputStream is = fRscByFile.getInputStream();
		try {
			Assert.assertNotNull(is);
		} finally {
			is.close();
		}
	}
	
	@Test
	public void testInputStreamByAbsolutePath() throws Exception {
		InputStream is = fRscByPath.getInputStream();
		try {
			Assert.assertNotNull(is);
		} finally {
			is.close();
		}
	}
	
	@Test
	public void testOutputStreamByFile() throws Exception {
		OutputStream os = fRscByFile.getOutputStream();
		try {
			Assert.assertNotNull(os);
		} finally {
			os.close();
		}
	}
	
	@Test
	public void testOutputStreamByAbsolutePath() throws Exception {
		OutputStream os = fRscByPath.getOutputStream();
		try {
			Assert.assertNotNull(os);
		} finally {
			os.close();
		}
	}
}
