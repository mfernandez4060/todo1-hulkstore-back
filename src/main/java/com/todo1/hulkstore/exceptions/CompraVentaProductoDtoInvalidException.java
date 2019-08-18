package com.todo1.hulkstore.exceptions;

import com.todo1.hulkstore.dtos.CompraVentaProductoDto;

/**
 * InventarioInsuficienteException CustomException
 * @author mariano
 *
 */
public class CompraVentaProductoDtoInvalidException  extends CustomException {
	private static final long serialVersionUID = 3325453395764420551L;

	public CompraVentaProductoDtoInvalidException(CompraVentaProductoDto compraVentaProducto) {
		super(String.format("Valor inválido compraVentaProducto [%s]",compraVentaProducto));
	}

}
