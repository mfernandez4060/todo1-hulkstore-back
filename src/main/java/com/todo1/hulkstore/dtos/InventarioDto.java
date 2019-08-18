package com.todo1.hulkstore.dtos;

import java.util.Date;

import lombok.Data;

/**
 * DTO de inventario de productos
 * 
 * @author marfernandez
 */
@Data
public class InventarioDto {
	/*
	 * Identificación único de inventario
	 */
	private Long id;

	/*
	 * Identificación del producto
	 */
	private ProductoDto producto;

	/*
	 * Cantidad acumulada del producto
	 */
	private Long stock;
	/*
	 * fecha última actualización de inventario
	 */
	private Date fechaUltimaActualizacion;
}