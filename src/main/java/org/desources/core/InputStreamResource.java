package org.desources.core;

import java.io.IOException;
import java.io.InputStream;

import org.desources.core.util.AssertUtil;

/**
 * @author pluser
 * @version 0.5 2014/11/27
 */
public class InputStreamResource extends AbstractResource {

	private static final String DEFAULT_NAME = "input stream resource";
	private static final String DEFAULT_DESCRIPTION = "resource loaded from input stream";
	
	private final InputStream inputStream;
	private final String name;
	private final String description;
	
	public InputStreamResource(InputStream inputStream) {
		this(inputStream, null, null);
	}
	
	public InputStreamResource(InputStream inputStream, String name) {
		this(inputStream, name, null);
	}
	
	public InputStreamResource(InputStream inputStream, String name, 
			String description) {
		AssertUtil.notNull(inputStream, "inputStream must not be null");
		
		this.inputStream = inputStream;
		this.name = (name == null ? DEFAULT_NAME : name);
		this.description = (description == null ? DEFAULT_DESCRIPTION : description);
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
	public boolean isWritable() {
		return false;
	}
	
	@Override
	public InputStream getInputStream() throws IOException {
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
