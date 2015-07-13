package org.desources.core;

import java.io.InputStream;

import org.desources.core.ClassPathResource;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author pluser
 * @version 0.5 2014/12/8
 */
public class TestClassPathResource {

	private static final String RELATIVE_PATH = "test.xml";
	private static final String RELATIVE_ABSOLUTE_PATH = "/org/desources/core/test.xml";
	private static final String ABSOLUTE_PATH = "org/desources/core/test.xml";

	@Test
	public void testFunctionByAbsolutePath() throws Exception {
		ClassPathResource resource = new ClassPathResource(ABSOLUTE_PATH);
		System.out.println("testFunctionByAbsolutePath: "
				+ "name[" + resource.getName()
				+ "], desc[" + resource.getDescription()
				+ "], path[" + resource.getPath()
				+ "], uri[" + resource.getUri()
				+ "], url[" + resource.getUrl()
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
	
	@Test
	public void testFunctionByRelativePathClazz() throws Exception {
		ClassPathResource resource = new ClassPathResource(RELATIVE_PATH, 
				TestClassPathResource.class);
		System.out.println("testFunctionByRelativePathClazz: "
				+ "name[" + resource.getName()
				+ "], desc[" + resource.getDescription()
				+ "], path[" + resource.getPath()
				+ "], uri[" + resource.getUri()
				+ "], url[" + resource.getUrl()
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
	
	@Test
	public void testFunctionByAbsolutePathClazz() throws Exception {
		ClassPathResource resource = new ClassPathResource(RELATIVE_ABSOLUTE_PATH, 
				TestClassPathResource.class);
		System.out.println("testFunctionByAbsolutePathClazz: "
				+ "name[" + resource.getName()
				+ "], desc[" + resource.getDescription()
				+ "], path[" + resource.getPath()
				+ "], uri[" + resource.getUri()
				+ "], url[" + resource.getUrl()
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
	
	@Test
	public void testFunctionByAbsolutePathClassLoader() throws Exception {
		ClassPathResource resource = new ClassPathResource(ABSOLUTE_PATH, 
				TestClassPathResource.class.getClassLoader());
		System.out.println("testFunctionByAbsolutePathClassLoader: "
				+ "name[" + resource.getName()
				+ "], desc[" + resource.getDescription()
				+ "], path[" + resource.getPath()
				+ "], uri[" + resource.getUri()
				+ "], url[" + resource.getUrl()
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
	
	@Test
	public void testFunctionByRelativePathClassLoaderClazz() throws Exception {
		ClassPathResource resource = new ClassPathResource(RELATIVE_PATH, 
				TestClassPathResource.class.getClassLoader(),
				TestClassPathResource.class);
		System.out.println("testFunctionByRelativePathClassLoaderClazz: "
				+ "name[" + resource.getName()
				+ "], desc[" + resource.getDescription()
				+ "], path[" + resource.getPath()
				+ "], uri[" + resource.getUri()
				+ "], url[" + resource.getUrl()
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
	
	@Test
	public void testFunctionByAbsolutePathClassLoaderClazz() throws Exception {
		ClassPathResource resource = new ClassPathResource(ABSOLUTE_PATH, 
				TestClassPathResource.class.getClassLoader(),
				TestClassPathResource.class);
		System.out.println("testFunctionByAbsolutePathClassLoaderClazz: "
				+ "name[" + resource.getName()
				+ "], desc[" + resource.getDescription()
				+ "], path[" + resource.getPath()
				+ "], uri[" + resource.getUri()
				+ "], url[" + resource.getUrl()
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
}
