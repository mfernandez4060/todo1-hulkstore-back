package com.todo1.hulkstore.dtos;

import lombok.Data;
/**
 * Dto CompraVentaProductoDto
 * @author mariano
 *
 */
@Data
public class CompraVentaProductoDto {
	/**
	 * Identificación del producto (dato negocio)
	 */
	private Long codProducto;

	/**
	 * Cantidad de productos
	 */
	private long cantidad;

	/**
	 * Costo de Producto
	 */
	private Double costo;

}
