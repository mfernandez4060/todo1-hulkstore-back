package com.todo1.hulkstore.exceptions;

/**
 * KardexNotFoundException CustomException
 * @author mariano
 *
 */
public class KardexNotFoundException  extends CustomException {
	private static final long serialVersionUID = 8611069238887691636L;

	public KardexNotFoundException(long id) {
		super(String.format("Kardex no encontrado: [%s] ",id));
	}

}
