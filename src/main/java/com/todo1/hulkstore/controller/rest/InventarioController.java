package com.todo1.hulkstore.controller.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo1.hulkstore.dtos.InventarioDto;
import com.todo1.hulkstore.services.InventarioService;

/**
 * Servicio Restful RestService Interfaz web de Inventario restful V1
 * 
 * @author marfernandez
 */
@RestController
@RequestMapping("/api/v1/inventario")
public class InventarioController {
	@Autowired
	private InventarioService inventarioService;

	@Autowired
	ModelMapper modelMapper;

	/**
	 * findAllInventario recupera todos los registros del inventarios
	 * 
	 * @param requestSecurityDto
	 * @return Retorna InventarioDto
	 */
	@ResponseBody
	@GetMapping(value = "/")
	public List<InventarioDto> findAllInventario() {

		return inventarioService.findAll().stream().map(inv -> modelMapper.map(inv, InventarioDto.class))
				.collect(Collectors.toList());
	}
}
