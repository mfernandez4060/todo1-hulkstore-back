package com.todo1.hulkstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * Entidad que modela procutos
 * 
 * @author marfernandez
 *
 */
@Entity
@Table(name = "productos", schema = "public", indexes = {
		@Index(name = "productos_01", columnList = "cod_producto", unique = true) })
@Data
public class Producto {
	/**
	 * Identificación único de registro
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Identificación del producto (dato negocio)
	 */
	@Column(length = 11, name = "cod_producto")
	private Long codProducto;

	/**
	 * Detalle del producto
	 */
	@Column(length = 255)
	private String descripcion;

	/**
	 * Tipo Superheroe
	 */
	@ManyToOne
	@JoinColumn(name = "tipo_superheroe_id", nullable = false)
	private TipoSuperheroe tipoSuperheroe;

	/**
	 * Costo de Producto
	 */
	@Column(length = 255)
	private Double costo;

}