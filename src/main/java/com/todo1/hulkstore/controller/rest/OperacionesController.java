package com.todo1.hulkstore.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.todo1.hulkstore.controller.bo.OperacionesBo;
import com.todo1.hulkstore.dtos.CompraVentaProductoDto;

/**
 * Servicio Restful RestService Interfaz web de Operaciones restful V1
 * 
 * @author marfernandez
 */
@RestController
@RequestMapping("/api/v1/operaciones")
public class OperacionesController {

	@Autowired
	OperacionesBo operacionesBo;
	
	/**
	 * CompraVentaProductoDto Operacion para compra de productos
	 * @param compraProductoDto
	 * @return void
	 */
	@PostMapping(value = "/producto/compra")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public void compraProducto(@RequestBody CompraVentaProductoDto compraProductoDto) {
		operacionesBo.compraProducto(compraProductoDto);
	}

	

	/**
	 * ventaProducto Operacion para venta de productos
	 * @param compraProductoDto
	 * @return void
	 */
	@PostMapping(value = "/producto/venta")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public void ventaProducto(@RequestBody CompraVentaProductoDto compraProductoDto) {
		operacionesBo.ventaProducto(compraProductoDto);

	}

}
