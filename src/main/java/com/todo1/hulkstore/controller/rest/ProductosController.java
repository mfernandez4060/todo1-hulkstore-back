package com.todo1.hulkstore.controller.rest;

import java.sql.Timestamp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.todo1.hulkstore.dtos.ProductoDto;
import com.todo1.hulkstore.exceptions.ProductoExistenteException;
import com.todo1.hulkstore.exceptions.ProductoNotFoundException;
import com.todo1.hulkstore.model.Inventario;
import com.todo1.hulkstore.model.Producto;
import com.todo1.hulkstore.model.TipoSuperheroe;
import com.todo1.hulkstore.services.InventarioService;
import com.todo1.hulkstore.services.ProductoService;
import com.todo1.hulkstore.services.TipoSuperheroeService;

/**
 * Servicio Restful RestService Interfaz web de Productos restful V1
 * 
 * @author marfernandez
 */
@RestController
@RequestMapping("/api/v1/productos")
public class ProductosController {
	@Autowired
	private ProductoService productoService;

	@Autowired
	private TipoSuperheroeService tipoSuperheroeService;

	@Autowired
	private InventarioService inventarioService;

	@Autowired
	ModelMapper modelMapper;

	/**
	 * findProductoByCodProducto, busca productos por codigo de producto
	 * 
	 * @param codProducto
	 * @return Retorna ProductoDto en aplication/json
	 */
	@ResponseBody
	@GetMapping(value = "/{codProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductoDto findProductoByCodProducto(@PathVariable long codProducto) {
		Producto producto = productoService.findByCodProducto(codProducto);

		return modelMapper.map(producto, ProductoDto.class);
	}

	/**
	 * addProducto, crea un producto
	 * 
	 * @param ProductoDto
	 * @return Http code 201 para operacion normal
	 */

	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductoDto addProducto(@RequestBody ProductoDto productoDto) {
		try {
			productoService.findByCodProducto(productoDto.getCodProducto());
		} catch (ProductoNotFoundException e) {
			return persistirProducto(productoDto);
		}

		throw new ProductoExistenteException(productoDto.getCodProducto());
	}

	/**
	 * addProducto, crea un producto
	 * 
	 * @param ProductoDto
	 * @return
	 * @return Http code 200 para operacion normal
	 */

	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductoDto updateProductoById(@PathVariable long id, @RequestBody ProductoDto productoDto) {
		Producto producto = productoService.findById(id);

		producto.setCosto(productoDto.getCosto());
		producto.setDescripcion(productoDto.getDescripcion());
		TipoSuperheroe tipoSuperheroe = tipoSuperheroeService.findById(productoDto.getTipoSuperheroe().getId());
		producto.setTipoSuperheroe(tipoSuperheroe);

		return modelMapper.map(productoService.save(producto), ProductoDto.class);
	}

	/**
	 * deleteProductoById, Elimina un producto
	 * 
	 * @param id
	 * @return
	 * @return Http code 200 para operacion normal
	 */
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteProductoById(@PathVariable("id") Long id) {
		// Verifica si el producto existe
		Producto producto = productoService.findById(id);

		Inventario invantario = inventarioService.findByCodProducto(producto.getCodProducto());
		inventarioService.delete(invantario);
	}

	/**
	 * persistirProducto, persiste un producto
	 * 
	 * @param ProductoDto
	 * @return ProductoDto
	 */
	ProductoDto persistirProducto(ProductoDto productoDto) {
		TipoSuperheroe tipoSuperheroe = tipoSuperheroeService.findById(productoDto.getTipoSuperheroe().getId());
		
		Producto producto = new Producto();
		producto.setCodProducto(productoDto.getCodProducto());
		producto.setCosto(productoDto.getCosto());
		producto.setDescripcion(producto.getDescripcion());
		producto.setTipoSuperheroe(tipoSuperheroe);
		
		Producto newProducto = productoService.save(producto);
		
		Inventario inventario = new Inventario();
		inventario.setFechaUltimaActualizacion(new Timestamp(System.currentTimeMillis()));
		inventario.setProducto(producto);
		inventario.setStock(0L);
		
		inventarioService.save(inventario);
		
		return modelMapper.map(newProducto, ProductoDto.class);
	}
}
