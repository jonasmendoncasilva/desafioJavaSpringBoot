package com.project.exceptions;

public class KeywordNotFoundException extends RuntimeException{ 
	private static final long serialVersionUID = 1L;

	public KeywordNotFoundException() {
		super("Entre com um campo válido");
	}
}
