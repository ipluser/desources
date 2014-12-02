package org.mana.core.io;

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

	public String getName() {
		return "";
	}
	
	public boolean exists() {
		return true;
	}
	
	public boolean isOpen() {
		return false;
	}
	
	public boolean isReadable() {
		return true;
	}
	
	public boolean isWritable() {
		return true;
	}
	
	public long size() throws IOException {
		InputStream inputStream = getInputStream();
		if (inputStream == null) {
			throw new FileNotFoundException(getDescription() 
					+ " cannot be found in the resource system,"
					+ " resource input stream must not be null");
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
	
	public long lastModified() throws IOException {
		throw new FileNotFoundException(getDescription() 
				+ "cannot be resolved last-modified timestamp");
	}
	
	public URL getUrl() throws IOException {
		throw new FileNotFoundException(getDescription() 
				+ " cannot be resolved to URL");
	}
	
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
