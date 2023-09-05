package com.project.exceptions;

public class KeywordNotFoundException extends IllegalStateException{ 
	private static final long serialVersionUID = 1L;

	public KeywordNotFoundException(String msg) {
		super(msg);
	}
}
