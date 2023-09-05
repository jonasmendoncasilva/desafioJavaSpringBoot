package com.project.exceptions;

public class EntityWithSameDataException extends RuntimeException{ 
	private static final long serialVersionUID = 1L;

	public EntityWithSameDataException(String msg) {
		super(msg);
	}
}
