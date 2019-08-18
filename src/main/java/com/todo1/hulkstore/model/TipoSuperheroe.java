package com.todo1.hulkstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * Entidad que modela el Tipo de Superheroe
 * 
 * @author marfernandez
 *
 */
@Data
@Entity(name = "tipo_superheroe")
public class TipoSuperheroe {
		/**
	 * Identificación único de tipo superheroe
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Descripción del superheroe
	 */
	@Column(length = 255)
	private String nombre;
}
