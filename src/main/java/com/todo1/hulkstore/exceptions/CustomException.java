package com.todo1.hulkstore.exceptions;

/***
 * CustomException Clase base para errores
 * @author marfernandez
 */
public class CustomException extends RuntimeException {
	private static final long serialVersionUID = -7976254375516760150L;

	public CustomException(String string) {
		super(string);
	}

}

