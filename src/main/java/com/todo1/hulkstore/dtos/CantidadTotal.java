package com.todo1.hulkstore.dtos;

import lombok.Data;
/**
 * Dto CantidadTotal
 * @author mariano
 *
 */
@Data
public class CantidadTotal {
	private long cantidad;
	private double total;

	public CantidadTotal() {
	}

	public CantidadTotal(int cantidad, double total) {
		this.cantidad = cantidad;
		this.total = total;
	}
}