package org.mana.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author pluser
 * @version 0.5 2014/11/27
 */
public class InputStreamResource extends AbstractResource {

	private final InputStream inputStream;
	private final String name;
	private final String description;
	
	private boolean read = true;
	
	public InputStreamResource(InputStream inputStream) {
		this(inputStream, "InputStream resource",
				"resource loaded from InputStream");
	}
	
	public InputStreamResource(InputStream inputStream, 
			String name, String description) {
		this.inputStream = inputStream;
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
	public InputStream getInputStream() throws IOException {
		if (!this.read) {
			throw new IOException("InputStream has already been read, " +
					"don't use InputStreamResource if a stream needs to be read multiple times");
		}
		
		this.read = false;
		return inputStream;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj == this ||
			(obj instanceof InputStreamResource 
					&& ((InputStreamResource) obj).inputStream.equals(this.inputStream)));
	}

	@Override
	public int hashCode() {
		return inputStream.hashCode();
	}

}
