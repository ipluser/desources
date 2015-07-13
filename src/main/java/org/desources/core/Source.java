package org.desources.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author pluser
 * @version 0.5 2014/11/22
 */
public interface Source {

	public InputStream getInputStream() throws IOException;
	
	public OutputStream getOutputStream() throws IOException;
}
