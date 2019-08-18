package com.todo1.hulkstore.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
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
 * Entidad que modela el sistema kardex que refleja los moviemientos de
 * productos
 * 
 * @author marfernandez
 */
@Entity
@Table(name = "kardex", schema = "public", indexes = {
		@Index(name = "kardex_01", columnList = "producto_id", unique = false) })
@Data
public class Kardex {

	public Kardex(Producto producto, long cantidad, TipoOperacion tipoOperacion, Double valorUnitario) {
		this.producto = producto;
		this.fecha = new Timestamp(System.currentTimeMillis());
		this.cantidad = cantidad;
		this.tipoOperacion = tipoOperacion;
		this.valorUnitario = valorUnitario;
	}

	public Kardex() {
		super();
	}

	/**
	 * Identificación único de kardex
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * fecha registro
	 */
	@Column(name = "fecha")
	private Timestamp fecha;

	/**
	 * Identificación del producto
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "producto_id", nullable = false)
	private Producto producto;

	/**
	 * Identifica el tipo de operacion COMPRA / VENTA
	 */
	@ManyToOne
	@JoinColumn(name = "tipo_operacion_id", nullable = false)
	private TipoOperacion tipoOperacion;

	/**
	 * Valor unitario del registro
	 */
	@Column(name = "valor_unitario")
	private double valorUnitario;

	/**
	 * Cantidad de productos
	 */
	private long cantidad;

}
