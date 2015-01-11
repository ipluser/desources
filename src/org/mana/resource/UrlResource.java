package org.mana.resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import org.mana.resource.util.AssertUtil;

/**
 * @author pluser
 * @version 0.5 2014/12/4
 */
public class UrlResource extends AbstractResource {

	private final URL url;
	
	public UrlResource(URL url) {
		AssertUtil.notNull(url, "url must not be null");
		
		this.url = url;
	}
	
	public UrlResource(URI uri) throws MalformedURLException {
		AssertUtil.notNull(uri, "uri must not be null");
		
		this.url = uri.toURL();
	}
	
	public UrlResource(String spec) throws MalformedURLException {
		AssertUtil.notNull(spec, "spec must not be null");
		
		this.url = new URL(spec);
	}
	
	@Override
	public String getName() {
		return url.toString();
	}
	
	@Override
	public String getDescription() {
		return "resource loaded from url [" + url.toString() + "]";
	}
	
	@Override
	public URL getUrl() throws IOException {
		return url;
	}
	
	@Override
	public URI getUri() throws IOException {
		try {
			return url.toURI();
		} catch (URISyntaxException e) {
			throw new IOException(e);
		}
	}
	
	@Override
	public boolean isWritable() {
		return false;
	}
	
	@Override
	public InputStream getInputStream() throws IOException {
		URLConnection con = this.url.openConnection();
		
		try {
			return con.getInputStream();
		}
		catch (IOException e) {
			if (con instanceof HttpURLConnection) {
				((HttpURLConnection)con).disconnect();
			}
			throw e;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj == this || 
				(obj instanceof UrlResource 
						&& ((UrlResource) obj).url.equals(this.url)));
	}

	@Override
	public int hashCode() {
		return url.hashCode();
	}
}
