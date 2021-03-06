package org.desources.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;

import org.desources.core.util.AssertUtil;

/**
 * @author pluser
 * @version 0.5 2014/11/22
 */
public class FileResource extends AbstractResource {

	private final File file;
	private final String path;
	
	public FileResource(File file) {
		AssertUtil.notNull(file, "file must not be null");
		
		this.file = file;
		this.path = this.file.getPath();
	}
	
	public FileResource(String path) {
		AssertUtil.notNull(path, "path must not be null");
		
		this.path = path;
		this.file = new File(this.path);
	}
	
	public File getFile() {
		return file;
	}
	
	public String getPath() {
		return path;
	}
	
	@Override
	public String getName() {
		return file.getName();
	}
	
	@Override
	public String getDescription() {
		return "resource loaded from file[" + path + "]";
	}
	
	@Override
	public boolean exists() {
		return file.exists();
	}
	
	@Override
	public boolean isReadable() {
		return (file.canRead() && !file.isDirectory());
	}
	
	@Override
	public boolean isWritable() {
		return (file.canWrite() && !file.isDirectory());
	}
	
	@Override
	public long lastModified() throws IOException {
		return file.lastModified();
	}
	
	@Override
	public URL getUrl() throws IOException {
		return file.toURI().toURL();
	}
	
	@Override
	public URI getUri() throws IOException {
		return file.toURI();
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return new FileInputStream(file);
	}
	
	@Override
	public OutputStream getOutputStream() throws IOException {
		return new FileOutputStream(file);
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj == this || 
				(obj instanceof FileResource 
						&& this.path.equals(((FileResource) obj).path)));
	}

	@Override
	public int hashCode() {
		return path.hashCode();
	}
}
