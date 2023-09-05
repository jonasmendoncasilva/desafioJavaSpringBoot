package com.project.exceptions;

public class EntityNotFoundException extends RuntimeException{ 
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(Object id) {
		super("Country não encontrado com id: "+id);
	}
}
