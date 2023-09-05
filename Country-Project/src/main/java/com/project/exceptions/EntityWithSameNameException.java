package com.project.exceptions;

public class EntityWithSameNameException extends RuntimeException{ 
	private static final long serialVersionUID = 1L;

	public EntityWithSameNameException() {
		super("Já existe um Country com este nome");
	}
}
