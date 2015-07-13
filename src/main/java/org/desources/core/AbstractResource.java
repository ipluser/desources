package org.desources.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author pluser
 * @version 0.5 2014/11/22
 */
public abstract class AbstractResource extends AbstractSource implements Resource {

	@Override
	public String getName() {
		return "";
	}
	
	@Override
	public boolean exists() {
		return true;
	}
	
	@Override
	public boolean isOpen() {
		return false;
	}
	
	@Override
	public boolean isReadable() {
		return true;
	}
	
	@Override
	public boolean isWritable() {
		return true;
	}
	
	@Override
	public long size() throws IOException {
		InputStream inputStream = getInputStream();
		if (inputStream == null) {
			throw new FileNotFoundException(getName() 
					+ " cannot be found in the resource system,"
					+ " InputStream of resource must not be null");
		}
		
		try {
			long size = 0;
			byte[] buf = new byte[512];
			int read;
			
			while((read = inputStream.read(buf)) != -1) {
				size += read;
			}
			return size;
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
			}
		}
	}
	
	@Override
	public long lastModified() throws IOException {
		throw new FileNotFoundException(getName() 
				+ " cannot be resolved last-modified timestamp");
	}
	
	@Override
	public URL getUrl() throws IOException {
		throw new FileNotFoundException(getName() 
				+ " cannot be resolved to URL");
	}
	
	@Override
	public URI getUri() throws IOException {
		URL url = getUrl();
		try {
			return url.toURI();
		} catch (URISyntaxException e) {
			throw new IOException("invalid URI [" + url + "]", e);
		}
	}
	
	@Override
	public String toString() {
		return getDescription();
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj == this || 
				(obj instanceof Resource 
						&& ((Resource) obj).getDescription().equals(getDescription())));
	}

	@Override
	public int hashCode() {
		return getDescription().hashCode();
	}
}
