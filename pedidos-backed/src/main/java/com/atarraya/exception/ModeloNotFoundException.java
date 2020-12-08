package com.atarraya.exception;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModeloNotFoundException extends RuntimeException{
	//Exepciones personalizadas
	
	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}
}
