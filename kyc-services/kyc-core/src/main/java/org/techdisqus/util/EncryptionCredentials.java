package org.techdisqus.util;

public class EncryptionCredentials {

	private String key;
	
	private String initVector;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getInitVector() {
		return initVector;
	}

	public void setInitVector(String initVector) {
		this.initVector = initVector;
	}

	public EncryptionCredentials(String key, String initVector) {
		super();
		this.key = key;
		this.initVector = initVector;
	}
}
