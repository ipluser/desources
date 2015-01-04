package org.mana.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author pluser
 * @version 0.5 2014/11/22
 */
public abstract class AbstractSource implements Source {

	@Override
	public InputStream getInputStream() throws IOException {
		throw new IOException("InputStream not supported");
	}
	
	@Override
	public OutputStream getOutputStream() throws IOException {
		throw new IOException("OutputStream not supported");
	}
}
