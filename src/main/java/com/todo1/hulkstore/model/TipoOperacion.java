package com.todo1.hulkstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Entidad que modela los tipo de operaciones habilitadas
 * 
 * @author marfernandez
 *
 */
@Entity
@Table(name = "tipo_operacion", schema = "public")
@Data
public class TipoOperacion {
	public enum Operacion {
		COMPRA, VENTA;

		public Long computarOperacion(long total, long cantidad) {
			long resultado = 0;

			if (this.equals(COMPRA))
				resultado = operacionSuma(total, cantidad);
			else if (this.equals(VENTA))
				resultado = operacionResta(total, cantidad);

			return resultado;
		}

		private long operacionResta(long total, long cantidad) {
			return total - cantidad;
		}

		private long operacionSuma(long total, long cantidad) {
			return total + cantidad;
		}
	}

	/*
	 * Identificación único de Tipo de operación
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/*
	 * Tipo de operaciones disponibles, compras, ventas, devoluciones, etc
	 */
	@Column(length = 255)
	private String descripcion;

	@Column(name = "operacion", nullable = false, length = 8, unique = true)
	@Enumerated(value = EnumType.STRING)
	private Operacion operacion;
}