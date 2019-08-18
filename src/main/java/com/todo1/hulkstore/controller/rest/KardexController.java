package com.todo1.hulkstore.controller.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo1.hulkstore.dtos.CantidadTotal;
import com.todo1.hulkstore.dtos.KardexDto;
import com.todo1.hulkstore.services.KardexService;

/**
 * Servicio Restful RestService Interfaz web de kardex restful V1
 * 
 * @author marfernandez
 */
@RestController
@RequestMapping("/api/v1/kardex")
public class KardexController {
	@Autowired
	private KardexService kardexService;

	/**
	 * listarKardex Retorna un listado Kardex por codProducto ordenado por fecha
	 * 
	 * @return List<KardexDto>
	 */
	@ResponseBody
	@GetMapping(value = "/{codProducto}")
	public List<KardexDto> findAllKardexByCodProducto(@PathVariable long codProducto) {
		CantidadTotal saldoAux = new CantidadTotal(0, 0.0);
		
		return kardexService.findByCodProductoOrderByFecha(codProducto).stream().map(k -> {
			KardexDto kardexDto = new KardexDto(k, saldoAux);

			saldoAux.setCantidad(kardexDto.getSaldo().getCantidad());
			saldoAux.setTotal(kardexDto.getSaldo().getTotal());

			return kardexDto;
		}).collect(Collectors.toList());
	}
}
