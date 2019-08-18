package com.todo1.hulkstore.exceptions;

/**
 * ProductoNotFoundException CustomException
 * @author mariano
 *
 */
public class ProductoNotFoundException  extends CustomException {
	private static final long serialVersionUID = -181372725865515242L;

	public ProductoNotFoundException(long id) {
		super(String.format("Producto no encontrado: [%s] ",id));
	}

}
