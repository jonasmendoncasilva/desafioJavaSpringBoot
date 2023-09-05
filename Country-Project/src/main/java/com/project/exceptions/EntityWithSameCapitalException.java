package com.project.exceptions;

public class EntityWithSameCapitalException extends RuntimeException{ 
	private static final long serialVersionUID = 1L;

	public EntityWithSameCapitalException() {
		super("Já existe um country com esta capital");
	}
}
