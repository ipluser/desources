package org.desources.core;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

import org.desources.core.util.AssertUtil;

/**
 * @author pluser
 * @version 0.5 2014/11/27
 */
public class OutputStreamResource extends AbstractResource {
	
	private static final String DEFAULT_NAME = "output stream resource";
	private static final String DEFAULT_DESCRIPTION = "resource loaded from output stream";

	private final OutputStream outputStream;
	private final String name;
	private final String description;
	
	private AtomicBoolean writable;
	
	public OutputStreamResource(OutputStream outputStream) {
		this(outputStream, null, null);
	}
	
	public OutputStreamResource(OutputStream outputStream, String name) {
		this(outputStream, name, null);
	}
	
	public OutputStreamResource(OutputStream outputStream, String name, 
			String description) {
		AssertUtil.notNull(outputStream, "outputStream must not be null");
		
		this.outputStream = outputStream;
		this.name = (name == null ? DEFAULT_NAME : name);
		this.description = (description == null ? DEFAULT_DESCRIPTION : description);
		this.writable = new AtomicBoolean(true);
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
	public boolean isReadable() {
		return false;
	}
	
	@Override
	public boolean isWritable() {
		return writable.get();
	}
	
	@Override
	public OutputStream getOutputStream() throws IOException {
		if (!writable.get()) {
			throw new IOException("OutputStream has already been write, " +
					"don't use OutputStreamResource if a stream needs to be write multiple times");
		}
		
		writable.set(false);
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
