package org.mana.core.io;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

/**
 * @author pluser
 * @version 0.5 2014/11/22
 */
public interface Resource extends Source {
	
	public String getName();
	
	public String getDescription();
	
	public boolean exists();
	
	public boolean isOpen();
	
	public boolean isReadable();
	
	public boolean isWritable();
	
	public long size() throws IOException;
	
	public long lastModified() throws IOException;
	
	public URL getUrl() throws IOException;
	
	public URI getUri() throws IOException;
}
