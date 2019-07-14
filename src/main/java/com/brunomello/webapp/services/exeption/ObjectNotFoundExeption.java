package com.brunomello.webapp.services.exeption;

public class ObjectNotFoundExeption extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundExeption(String msg) {
		super (msg);
	}

}
