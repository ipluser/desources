package org.mana.core.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * @author pluser
 * @version 0.5 2014/11/25
 */
public class ByteArrayResource extends AbstractResource {

	private final byte[] byteArray;
	private final String name;
	private final String description;
	
	public ByteArrayResource(byte[] byteArray) {
		this(byteArray, "byte array resource",
				"resource loaded from byte array");
	}
	
	public ByteArrayResource(byte[] byteArray, String name, 
			String description) {
		if (byteArray == null) {
			throw new IllegalArgumentException(
					"byte array must not be null");
		}
		
		this.byteArray = byteArray;
		this.name = (name == null ? "" : name);
		this.description = (description == null ? "" : description);
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
