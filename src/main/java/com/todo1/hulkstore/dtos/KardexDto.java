package com.todo1.hulkstore.dtos;

import java.util.Date;

import com.todo1.hulkstore.model.Kardex;
import com.todo1.hulkstore.model.Producto;
import com.todo1.hulkstore.model.TipoOperacion;

import lombok.Data;
/**
 * Dto de Kardex
 * @author mariano
 *
 */
@Data
public class KardexDto {

	private Date fecha;
	private Producto producto;
	private double valorUnitario;
	private TipoOperacion tipoOperacion;
	private CantidadTotal entrada;
	private CantidadTotal salida;
	private CantidadTotal saldo;
	

	public KardexDto(Kardex kardex, CantidadTotal saldo) {
		this.fecha = kardex.getFecha();
		this.producto = kardex.getProducto();
		this.valorUnitario = kardex.getValorUnitario();
		this.tipoOperacion = kardex.getTipoOperacion();
		this.entrada = new CantidadTotal(0,0.0);
		this.salida = new CantidadTotal(0,0.0);
		this.saldo = new CantidadTotal(0,0.0);
		procesaSaldos(kardex, saldo, this);
	}

	/**
	 * procesaSaldos Actualiza saldos de entrada, salida y saldo
	 * @param kardex
	 * @param saldo
	 * @param kardexDto
	 */
	void procesaSaldos(Kardex kardex, CantidadTotal saldo, KardexDto kardexDto) {
		switch (this.tipoOperacion.getOperacion()) {
		case COMPRA:
			kardexDto.entrada.setCantidad(kardex.getCantidad());
			kardexDto.entrada.setTotal(kardex.getCantidad() * kardex.getValorUnitario());
			
			kardexDto.saldo.setCantidad(saldo.getCantidad() + this.entrada.getCantidad());
			kardexDto.saldo.setTotal(saldo.getTotal() + this.entrada.getTotal() * -1);
			break;
		case VENTA:
			kardexDto.salida.setCantidad(kardex.getCantidad());
			kardexDto.salida.setTotal(kardex.getCantidad() * kardex.getValorUnitario());
			
			kardexDto.saldo.setCantidad(saldo.getCantidad() - this.salida.getCantidad());
			kardexDto.saldo.setTotal(saldo.getTotal() + this.salida.getTotal()); 
			break;
		}
	}

	public static CantidadTotal getInstanceCantidadTotal() {
		return new CantidadTotal();
	}
}
