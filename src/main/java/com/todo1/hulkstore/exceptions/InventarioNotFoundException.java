package com.todo1.hulkstore.exceptions;

/**
 * InventarioNotFoundException CustomException
 * @author mariano
 *
 */
public class InventarioNotFoundException extends CustomException {
	private static final long serialVersionUID = -2947611522909338873L;

	public InventarioNotFoundException(long id) {
		super(String.format("Inventario no encontrado: [%s] ",id));
	}

}
