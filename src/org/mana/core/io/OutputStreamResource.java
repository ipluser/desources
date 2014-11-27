package org.mana.core.io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author pluser
 * @version 0.5 2014/11/27
 */
public class OutputStreamResource extends AbstractResource {

	private final OutputStream outputStream;
	private final String name;
	private final String description;
	
	private boolean read = true;
	
	public OutputStreamResource(OutputStream outputStream) {
		this(outputStream, "OutputStream resource",
				"resource loaded from OutputStream");
	}
	
	public OutputStreamResource(OutputStream outputStream, 
			String name, String description) {
		this.outputStream = outputStream;
		this.name = name;
		this.description = description;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public boolean isOpen() {
		return true;
	}
	
	@Override
	public OutputStream getOutputStream() throws IOException {
		if (!this.read) {
			throw new IOException("OutputStream has already been read, " +
					"don't use OutputStreamResource if a stream needs to be read multiple times");
		}
		
		this.read = false;
		return outputStream;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj == this ||
			(obj instanceof OutputStreamResource 
					&& ((OutputStreamResource) obj).outputStream.equals(this.outputStream)));
	}

	@Override
	public int hashCode() {
		return outputStream.hashCode();
	}

}
