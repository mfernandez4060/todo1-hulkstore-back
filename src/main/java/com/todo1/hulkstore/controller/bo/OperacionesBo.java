package com.todo1.hulkstore.controller.bo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.todo1.hulkstore.dtos.CompraVentaProductoDto;
import com.todo1.hulkstore.exceptions.CantidadInvalidaException;
import com.todo1.hulkstore.exceptions.CompraVentaProductoDtoInvalidException;
import com.todo1.hulkstore.exceptions.InventarioInsuficienteException;
import com.todo1.hulkstore.exceptions.ValorInvalidoException;
import com.todo1.hulkstore.model.Inventario;
import com.todo1.hulkstore.model.Kardex;
import com.todo1.hulkstore.model.Producto;
import com.todo1.hulkstore.model.TipoOperacion;
import com.todo1.hulkstore.model.TipoOperacion.Operacion;
import com.todo1.hulkstore.services.InventarioService;
import com.todo1.hulkstore.services.KardexService;
import com.todo1.hulkstore.services.ProductoService;
import com.todo1.hulkstore.services.TipoOperacionService;

/**
 * Capa de abstracción para reglas de negocio
 * @author mariano
 *
 */
@Component
public class OperacionesBo {
	@Autowired
	private ProductoService productoService;

	@Autowired
	private KardexService kardexService;

	@Autowired
	private TipoOperacionService tipoOperacionService;

	@Autowired
	private InventarioService inventarioService;

	/**
	 * Procesa transaccion para compra de producto
	 * @param compraProductoDto
	 */
	public void compraProducto(CompraVentaProductoDto compraProductoDto) {
		validCompraVentaProducto(compraProductoDto);

		Producto producto = updateProducto(compraProductoDto);

		updateKardex(Operacion.COMPRA, compraProductoDto, producto);

		updateInventario(Operacion.COMPRA, compraProductoDto);
	}

	/**
	 * Procesa la transaccion para venta de producto
	 * @param compraProductoDto
	 */
	public void ventaProducto(CompraVentaProductoDto compraProductoDto) {
		validCompraVentaProducto(compraProductoDto);

		updateInventario(Operacion.VENTA, compraProductoDto);

		Producto producto = productoService.findByCodProducto(compraProductoDto.getCodProducto());

		updateKardex(Operacion.VENTA, compraProductoDto, producto);
	}
	
	
	/**
	 * Validación de compraProductoDto
	 * @param compraProductoDto
	 */
	private void validCompraVentaProducto(CompraVentaProductoDto compraProductoDto) {
		if (compraProductoDto == null) {
			throw new CompraVentaProductoDtoInvalidException(compraProductoDto);
		}
		
		if (!(compraProductoDto.getCantidad() > 0 && compraProductoDto.getCantidad() <= 1000)) {
			throw new CantidadInvalidaException(compraProductoDto.getCantidad());
		}
		
		if (!(compraProductoDto.getCosto() > 0 && compraProductoDto.getCosto() <= 10000)) {
			throw new ValorInvalidoException(compraProductoDto.getCosto());
		}
	}
	
	/**
	 * updateInventario Actualiza inventario
	 * @param operacion
	 * @param compraProductoDto
	 * @return Inventario
	 */
	private Inventario updateInventario(Operacion operacion, CompraVentaProductoDto compraProductoDto) {
		Inventario inventario = inventarioService.findByCodProducto(compraProductoDto.getCodProducto());
		if (operacion.equals(Operacion.VENTA) && inventario.getStock() < compraProductoDto.getCantidad()) {
				throw new InventarioInsuficienteException(compraProductoDto.getCodProducto(),
						compraProductoDto.getCantidad(), inventario.getStock());
		}
		inventario.setFechaUltimaActualizacion(new Date());
		inventario.setStock(operacion.computarOperacion(inventario.getStock(), compraProductoDto.getCantidad()));
		return inventarioService.save(inventario);
	}

	/**
	 * updateKardex Actualiza kardex
	 * @param operacion
	 * @param compraProductoDto
	 * @param producto
	 * @return Kardex
	 */
	private Kardex updateKardex(Operacion operacion, CompraVentaProductoDto compraProductoDto, Producto producto) {
		TipoOperacion tipoOperacion = tipoOperacionService.findByOperacion(operacion);
		Kardex kardex = new Kardex(producto, compraProductoDto.getCantidad(), tipoOperacion,
				compraProductoDto.getCosto());
		
		return kardexService.save(kardex);
	}

	/**
	 * updateProducto Actualiza producto
	 * @param compraProductoDto
	 * @return
	 */
	private Producto updateProducto(CompraVentaProductoDto compraProductoDto) {
		Producto producto = productoService.findByCodProducto(compraProductoDto.getCodProducto());
		producto.setCosto(compraProductoDto.getCosto());

		return productoService.save(producto);
	}

}
