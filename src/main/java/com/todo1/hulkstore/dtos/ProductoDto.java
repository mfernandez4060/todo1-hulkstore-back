package com.todo1.hulkstore.dtos;

import lombok.Data;

/**
 * DTO de procutos
 * 
 * @author marfernandez
 *
 */
@Data
public class ProductoDto {
	/**
	 * Identificación único de registro
	 */
	private Long id;

	/**
	 * Identificación del producto (dato negocio)
	 */
	private Long codProducto;

	/**
	 * Detalle del producto
	 */
	private String descripcion;

	/**
	 * Tipo Superheroe
	 */
	private TipoSuperheroeDto tipoSuperheroe;
	
	/**
	 * Costo de Producto
	 */
	private Double costo;
}
