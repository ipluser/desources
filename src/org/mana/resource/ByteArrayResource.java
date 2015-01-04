package org.mana.resource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * @author pluser
 * @version 0.5 2014/11/25
 */
public class ByteArrayResource extends AbstractResource {

	private static final String DEFAULT_NAME = "byte array resource";
	private static final String DEFAULT_DESCRIPTION = "resource loaded from byte array";
	
	private final byte[] byteArray;
	private final String name;
	private final String description;
	
	public ByteArrayResource(byte[] byteArray) {
		this(byteArray, null, null);
	}
	
	public ByteArrayResource(byte[] byteArray, String name, 
			String description) {
		if (byteArray == null) {
			throw new IllegalArgumentException(
					"byte array must not be null");
		}
		
		this.byteArray = byteArray;
		this.name = (name == null ? DEFAULT_NAME : name);
		this.description = (description == null ? DEFAULT_DESCRIPTION : description);
	}
	
	public byte[] getByteArray() {
		return Arrays.copyOf(byteArray, byteArray.length);
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
	public boolean isWritable() {
		return false;
	}
	
	@Override
	public long size() throws IOException {
		return byteArray.length;
	}
	
	@Override
	public InputStream getInputStream() throws IOException {
		return new ByteArrayInputStream(byteArray);
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj == this || 
				(obj instanceof ByteArrayResource 
						&& Arrays.equals(((ByteArrayResource) obj).byteArray, this.byteArray)));
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(byteArray);
	}
}
