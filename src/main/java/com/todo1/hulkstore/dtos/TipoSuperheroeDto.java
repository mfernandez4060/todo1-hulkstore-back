package com.todo1.hulkstore.dtos;

import lombok.Data;

/**
 * DTO de Tipo de Superheroe
 * 
 * @author marfernandez
 *
 */
@Data
public class TipoSuperheroeDto {
	/**
	 * Identificación único de tipo superheroe
	 */
	private Long id;

	/**
	 * Descripción del superheroe
	 */
	private String nombre;
}
