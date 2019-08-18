package com.todo1.hulkstore.exceptions;

/**
 * InventarioInsuficienteException CustomException
 * @author mariano
 *
 */
public class InventarioInsuficienteException  extends CustomException {
	private static final long serialVersionUID = 3325453395764420551L;

	public InventarioInsuficienteException(Long codProducto, long cantidad, Long stock) {
		super(String.format("Stock insuficiente para el producto [%s] cantidad venta [%s] existencia [%s]",codProducto,cantidad, stock));
	}


}
