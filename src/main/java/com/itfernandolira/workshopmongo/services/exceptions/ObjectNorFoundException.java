package com.itfernandolira.workshopmongo.services.exceptions;

public class ObjectNorFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNorFoundException(String msg) {
		super(msg);
	}

}
