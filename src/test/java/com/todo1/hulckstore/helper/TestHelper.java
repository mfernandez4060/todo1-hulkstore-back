package com.todo1.hulckstore.helper;

import java.sql.Timestamp;
import java.util.Date;

import com.todo1.hulkstore.dtos.CompraVentaProductoDto;
import com.todo1.hulkstore.model.Inventario;
import com.todo1.hulkstore.model.Kardex;
import com.todo1.hulkstore.model.Producto;
import com.todo1.hulkstore.model.TipoOperacion;
import com.todo1.hulkstore.model.TipoSuperheroe;
/**
 * Helper para popular las entidades en test
 * @author mariano
 *
 */
public class TestHelper {

	public static Kardex buildKardex(long id, Timestamp fecha, Producto producto, TipoOperacion tipoOperacion,double valorUnitario, long cantiad) {
		Kardex value = new Kardex();

		value.setId(id);
		value.setFecha(fecha);
		value.setProducto(producto);
		value.setTipoOperacion(tipoOperacion);
		value.setCantidad(cantiad);
		value.setValorUnitario(valorUnitario);

		return value;
	}

	public static Inventario buildInventario(long id, Producto producto, long stock, Date fechaUltimaActualizacion) {
		Inventario value = new Inventario();

		value.setId(id);
		value.setProducto(producto);
		value.setStock(stock);
		value.setFechaUltimaActualizacion(fechaUltimaActualizacion);

		return value;
	}

	public static Producto buildProducto(long id, long codProducto, String descripcion, TipoSuperheroe tipoSuperheroe, double costo) {
		Producto value = new Producto();

		value.setId(id);
		value.setCodProducto(codProducto);
		value.setDescripcion(descripcion);
		value.setTipoSuperheroe(tipoSuperheroe);
		value.setCosto(costo);

		return value;
	}

	public static TipoSuperheroe buildTipoSuperheroe(long id, String nombre) {
		TipoSuperheroe value = new TipoSuperheroe();

		value.setId(id);
		value.setNombre(nombre);

		return value;
	}

	public static TipoOperacion buildTipoOperacion(long id, String descripcion, TipoOperacion.Operacion operacion) {
		TipoOperacion value = new TipoOperacion();

		value.setId(id);
		value.setDescripcion(descripcion);
		value.setOperacion(operacion);

		return value;
	}

	public static CompraVentaProductoDto buildCompraProducto(long cantidad, Long codProducto, Double costo) {
		CompraVentaProductoDto compraVentaProductoDto = new CompraVentaProductoDto();
		
		compraVentaProductoDto.setCantidad(cantidad);
		compraVentaProductoDto.setCodProducto(codProducto);
		compraVentaProductoDto.setCosto(costo);
		
		return compraVentaProductoDto;
	}
}
