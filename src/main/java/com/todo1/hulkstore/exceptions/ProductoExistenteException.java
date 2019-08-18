package com.todo1.hulkstore.exceptions;

/**
 * ProductoExistenteException ProductoExistenteException
 * @author mariano
 *
 */
public class ProductoExistenteException  extends CustomException {
	private static final long serialVersionUID = -181372725865515242L;

	public ProductoExistenteException(long codProducto) {
		super(String.format("El producto ya existe: [%s] ",codProducto));
	}

}
