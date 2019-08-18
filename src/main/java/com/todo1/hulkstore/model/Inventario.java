package com.todo1.hulkstore.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * Entidad que modela el inventario de productos
 * 
 * @author marfernandez
 */
@Entity
@Table(name = "inventario", schema = "public", indexes = {
		@Index(name = "inventario_01", columnList = "producto_id", unique = true) })
@Data
public class Inventario {
	/*
	 * Identificación único de inventario
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/*
	 * Identificación del producto
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "producto_id", referencedColumnName = "id")
	private Producto producto;

	/*
	 * Cantidad acumulada del producto
	 */
	@Column(length = 11)
	private Long stock;
	/*
	 * fecha última actualización de inventario
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_ultima_act")
	private Date fechaUltimaActualizacion;
}