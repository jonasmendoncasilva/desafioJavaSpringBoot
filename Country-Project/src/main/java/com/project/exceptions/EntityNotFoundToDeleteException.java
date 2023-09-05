package com.project.exceptions;

public class EntityNotFoundToDeleteException extends RuntimeException{ 
	private static final long serialVersionUID = 1L;

	public EntityNotFoundToDeleteException(Object id) {
		super("Country para deletar não encontrado com id: "+id);
	}
}
