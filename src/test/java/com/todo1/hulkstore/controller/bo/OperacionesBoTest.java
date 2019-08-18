package com.todo1.hulkstore.controller.bo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Timestamp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.todo1.hulckstore.helper.TestHelper;
import com.todo1.hulkstore.dtos.CompraVentaProductoDto;
import com.todo1.hulkstore.exceptions.CantidadInvalidaException;
import com.todo1.hulkstore.exceptions.CompraVentaProductoDtoInvalidException;
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

@RunWith(SpringRunner.class)
@EnableConfigurationProperties
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OperacionesBoTest {

	private static final Producto PRODUCT_VALID = TestHelper.buildProducto(1L, 1L, "Tasa Hulk",
			TestHelper.buildTipoSuperheroe(1, "Marvel"), 100.0);
	private static final TipoOperacion TIPO_OPERACION_VALID = TestHelper.buildTipoOperacion(1L, "Compra articulos",
			TipoOperacion.Operacion.COMPRA);
	private static final Kardex KARDEX_VALIDO = TestHelper.buildKardex(1, new Timestamp(System.currentTimeMillis()),
			TestHelper.buildProducto(1L, 1L, "Tasa Hulk", TestHelper.buildTipoSuperheroe(1, "Marvel"), 100.0),
			TestHelper.buildTipoOperacion(1L, "Compra articulos", TipoOperacion.Operacion.COMPRA), 100.0, 10);
	private static final CompraVentaProductoDto COMPRA_PRODUCTO_DTO_VALIDO = TestHelper.buildCompraProducto(1L, 1001L,
			10.23);
	private static final CompraVentaProductoDto COMPRA_PRODUCTO_DTO_CANTIDAD_INVALIDA_DOWN = TestHelper.buildCompraProducto(0L, 1001L, 10.23);
	private static final CompraVentaProductoDto COMPRA_PRODUCTO_DTO_CANTIDAD_INVALIDA_UP = TestHelper.buildCompraProducto(999999L, 1001L, 10.23);
	
	private static final CompraVentaProductoDto COMPRA_PRODUCTO_DTO_NULO = null;
	private static final Inventario INVENTARIO_VALID = TestHelper.buildInventario(1L, PRODUCT_VALID, 1L, new Timestamp(System.currentTimeMillis()));
	private static final CompraVentaProductoDto COMPRA_PRODUCTO_DTO_VALOR_INVALIDA_DOWN = TestHelper.buildCompraProducto(10L, 1001L, 0.0);
	private static final CompraVentaProductoDto COMPRA_PRODUCTO_DTO_VALOR_INVALIDA_UP = TestHelper.buildCompraProducto(10L, 1001L, 9999999.23);

	@BeforeEach
	void init() {
	}

	@AfterEach
	void tearDown() {
	}

	@Mock
	private ProductoService productoService;

	@Mock
	private KardexService kardexService;

	@Mock
	private TipoOperacionService tipoOperacionService;

	@Mock
	private InventarioService inventarioService;

	@InjectMocks
	private OperacionesBo sut;

	@Test()
	public void compraProducto_ConCompraVentaProductoDtoValido_retornaVoid() throws Exception {
		Mockito.when(inventarioService.findByCodProducto(Mockito.anyLong())).thenReturn(INVENTARIO_VALID);
		Mockito.when(productoService.findByCodProducto(Mockito.anyLong())).thenReturn(PRODUCT_VALID);
		Mockito.when(productoService.save(Mockito.any(Producto.class))).thenReturn(PRODUCT_VALID);
		Mockito.when(tipoOperacionService.findByOperacion(TIPO_OPERACION_VALID.getOperacion())).thenReturn(TIPO_OPERACION_VALID);
		PowerMockito.whenNew(Kardex.class).withAnyArguments().thenReturn(KARDEX_VALIDO);
		Mockito.when(kardexService.save(Mockito.any(Kardex.class))).thenReturn(KARDEX_VALIDO);

		sut.compraProducto(COMPRA_PRODUCTO_DTO_VALIDO);

		Mockito.verify(kardexService, Mockito.times(1)).save(Mockito.any(Kardex.class));
		Mockito.verify(productoService, Mockito.times(1)).findByCodProducto(Mockito.anyLong());
		Mockito.verify(tipoOperacionService, Mockito.times(1)).findByOperacion(Mockito.any(Operacion.class));
		Mockito.verify(kardexService, Mockito.times(1)).save(Mockito.any(Kardex.class));
	}
	
	@Test()
	public void compraProducto_ConCompraVentaProductoNull_throwException() throws Exception {
		Mockito.when(inventarioService.findByCodProducto(Mockito.anyLong())).thenReturn(INVENTARIO_VALID);
		Mockito.when(productoService.findByCodProducto(Mockito.anyLong())).thenReturn(PRODUCT_VALID);
		Mockito.when(productoService.save(Mockito.any(Producto.class))).thenReturn(PRODUCT_VALID);
		Mockito.when(tipoOperacionService.findByOperacion(TIPO_OPERACION_VALID.getOperacion())).thenReturn(TIPO_OPERACION_VALID);
		PowerMockito.whenNew(Kardex.class).withAnyArguments().thenReturn(KARDEX_VALIDO);
		Mockito.when(kardexService.save(Mockito.any(Kardex.class))).thenReturn(KARDEX_VALIDO);

		Exception thrown = assertThrows(CompraVentaProductoDtoInvalidException.class, () -> sut.compraProducto(COMPRA_PRODUCTO_DTO_NULO));

		assertEquals(thrown.getClass(), CompraVentaProductoDtoInvalidException.class);

	}	
	
	@Test()
	public void compraProducto_ConCompraVentaProductoCantidadInvalidaBajoLimite_throwException() throws Exception {
		Mockito.when(inventarioService.findByCodProducto(Mockito.anyLong())).thenReturn(INVENTARIO_VALID);
		Mockito.when(productoService.findByCodProducto(Mockito.anyLong())).thenReturn(PRODUCT_VALID);
		Mockito.when(productoService.save(Mockito.any(Producto.class))).thenReturn(PRODUCT_VALID);
		Mockito.when(tipoOperacionService.findByOperacion(TIPO_OPERACION_VALID.getOperacion())).thenReturn(TIPO_OPERACION_VALID);
		PowerMockito.whenNew(Kardex.class).withAnyArguments().thenReturn(KARDEX_VALIDO);
		Mockito.when(kardexService.save(Mockito.any(Kardex.class))).thenReturn(KARDEX_VALIDO);

		Exception thrown = assertThrows(CantidadInvalidaException.class, () -> sut.compraProducto(COMPRA_PRODUCTO_DTO_CANTIDAD_INVALIDA_DOWN));

		assertEquals(thrown.getClass(), CantidadInvalidaException.class);

	}		
	@Test()
	public void compraProducto_ConCompraVentaProductoCantidadInvalidaSobreLimite_throwException() throws Exception {
		Mockito.when(inventarioService.findByCodProducto(Mockito.anyLong())).thenReturn(INVENTARIO_VALID);
		Mockito.when(productoService.findByCodProducto(Mockito.anyLong())).thenReturn(PRODUCT_VALID);
		Mockito.when(productoService.save(Mockito.any(Producto.class))).thenReturn(PRODUCT_VALID);
		Mockito.when(tipoOperacionService.findByOperacion(TIPO_OPERACION_VALID.getOperacion())).thenReturn(TIPO_OPERACION_VALID);
		PowerMockito.whenNew(Kardex.class).withAnyArguments().thenReturn(KARDEX_VALIDO);
		Mockito.when(kardexService.save(Mockito.any(Kardex.class))).thenReturn(KARDEX_VALIDO);

		Exception thrown = assertThrows(CantidadInvalidaException.class, () -> sut.compraProducto(COMPRA_PRODUCTO_DTO_CANTIDAD_INVALIDA_UP));

		assertEquals(thrown.getClass(), CantidadInvalidaException.class);

	}		
	
	@Test()
	public void compraProducto_ConCompraVentaProductoValorInvalidoBajoLimite_throwException() throws Exception {
		Mockito.when(inventarioService.findByCodProducto(Mockito.anyLong())).thenReturn(INVENTARIO_VALID);
		Mockito.when(productoService.findByCodProducto(Mockito.anyLong())).thenReturn(PRODUCT_VALID);
		Mockito.when(productoService.save(Mockito.any(Producto.class))).thenReturn(PRODUCT_VALID);
		Mockito.when(tipoOperacionService.findByOperacion(TIPO_OPERACION_VALID.getOperacion())).thenReturn(TIPO_OPERACION_VALID);
		PowerMockito.whenNew(Kardex.class).withAnyArguments().thenReturn(KARDEX_VALIDO);
		Mockito.when(kardexService.save(Mockito.any(Kardex.class))).thenReturn(KARDEX_VALIDO);

		Exception thrown = assertThrows(ValorInvalidoException.class, () -> sut.compraProducto(COMPRA_PRODUCTO_DTO_VALOR_INVALIDA_DOWN));

		assertEquals(thrown.getClass(), ValorInvalidoException.class);

	}		
	@Test()
	public void compraProducto_ConCompraVentaProductoValorInvalidoSobreLimite_throwException() throws Exception {
		Mockito.when(inventarioService.findByCodProducto(Mockito.anyLong())).thenReturn(INVENTARIO_VALID);
		Mockito.when(productoService.findByCodProducto(Mockito.anyLong())).thenReturn(PRODUCT_VALID);
		Mockito.when(productoService.save(Mockito.any(Producto.class))).thenReturn(PRODUCT_VALID);
		Mockito.when(tipoOperacionService.findByOperacion(TIPO_OPERACION_VALID.getOperacion())).thenReturn(TIPO_OPERACION_VALID);
		PowerMockito.whenNew(Kardex.class).withAnyArguments().thenReturn(KARDEX_VALIDO);
		Mockito.when(kardexService.save(Mockito.any(Kardex.class))).thenReturn(KARDEX_VALIDO);

		Exception thrown = assertThrows(ValorInvalidoException.class, () -> sut.compraProducto(COMPRA_PRODUCTO_DTO_VALOR_INVALIDA_UP));

		assertEquals(thrown.getClass(), ValorInvalidoException.class);

	}			

	
	
	
	@Test()
	public void ventaProducto_ConCompraVentaProductoDtoValido_retornaVoid() throws Exception {
		Mockito.when(inventarioService.findByCodProducto(Mockito.anyLong())).thenReturn(INVENTARIO_VALID);
		Mockito.when(productoService.findByCodProducto(Mockito.anyLong())).thenReturn(PRODUCT_VALID);
		Mockito.when(productoService.save(Mockito.any(Producto.class))).thenReturn(PRODUCT_VALID);
		Mockito.when(tipoOperacionService.findByOperacion(TIPO_OPERACION_VALID.getOperacion())).thenReturn(TIPO_OPERACION_VALID);
		PowerMockito.whenNew(Kardex.class).withAnyArguments().thenReturn(KARDEX_VALIDO);
		Mockito.when(kardexService.save(Mockito.any(Kardex.class))).thenReturn(KARDEX_VALIDO);

		sut.ventaProducto(COMPRA_PRODUCTO_DTO_VALIDO);

		Mockito.verify(kardexService, Mockito.times(1)).save(Mockito.any(Kardex.class));
		Mockito.verify(productoService, Mockito.times(1)).findByCodProducto(Mockito.anyLong());
		Mockito.verify(tipoOperacionService, Mockito.times(1)).findByOperacion(Mockito.any(Operacion.class));
		Mockito.verify(kardexService, Mockito.times(1)).save(Mockito.any(Kardex.class));
	}
	
	@Test()
	public void ventaProducto_ConCompraVentaProductoNull_throwException() throws Exception {
		Mockito.when(inventarioService.findByCodProducto(Mockito.anyLong())).thenReturn(INVENTARIO_VALID);
		Mockito.when(productoService.findByCodProducto(Mockito.anyLong())).thenReturn(PRODUCT_VALID);
		Mockito.when(productoService.save(Mockito.any(Producto.class))).thenReturn(PRODUCT_VALID);
		Mockito.when(tipoOperacionService.findByOperacion(TIPO_OPERACION_VALID.getOperacion())).thenReturn(TIPO_OPERACION_VALID);
		PowerMockito.whenNew(Kardex.class).withAnyArguments().thenReturn(KARDEX_VALIDO);
		Mockito.when(kardexService.save(Mockito.any(Kardex.class))).thenReturn(KARDEX_VALIDO);

		Exception thrown = assertThrows(CompraVentaProductoDtoInvalidException.class, () -> sut.ventaProducto(COMPRA_PRODUCTO_DTO_NULO));

		assertEquals(thrown.getClass(), CompraVentaProductoDtoInvalidException.class);

	}	
	
	@Test()
	public void ventaProducto_ConCompraVentaProductoCantidadInvalidaBajoLimite_throwException() throws Exception {
		Mockito.when(inventarioService.findByCodProducto(Mockito.anyLong())).thenReturn(INVENTARIO_VALID);
		Mockito.when(productoService.findByCodProducto(Mockito.anyLong())).thenReturn(PRODUCT_VALID);
		Mockito.when(productoService.save(Mockito.any(Producto.class))).thenReturn(PRODUCT_VALID);
		Mockito.when(tipoOperacionService.findByOperacion(TIPO_OPERACION_VALID.getOperacion())).thenReturn(TIPO_OPERACION_VALID);
		PowerMockito.whenNew(Kardex.class).withAnyArguments().thenReturn(KARDEX_VALIDO);
		Mockito.when(kardexService.save(Mockito.any(Kardex.class))).thenReturn(KARDEX_VALIDO);

		Exception thrown = assertThrows(CantidadInvalidaException.class, () -> sut.ventaProducto(COMPRA_PRODUCTO_DTO_CANTIDAD_INVALIDA_DOWN));

		assertEquals(thrown.getClass(), CantidadInvalidaException.class);

	}		
	@Test()
	public void ventaProducto_ConCompraVentaProductoCantidadInvalidaSobreLimite_throwException() throws Exception {
		Mockito.when(inventarioService.findByCodProducto(Mockito.anyLong())).thenReturn(INVENTARIO_VALID);
		Mockito.when(productoService.findByCodProducto(Mockito.anyLong())).thenReturn(PRODUCT_VALID);
		Mockito.when(productoService.save(Mockito.any(Producto.class))).thenReturn(PRODUCT_VALID);
		Mockito.when(tipoOperacionService.findByOperacion(TIPO_OPERACION_VALID.getOperacion())).thenReturn(TIPO_OPERACION_VALID);
		PowerMockito.whenNew(Kardex.class).withAnyArguments().thenReturn(KARDEX_VALIDO);
		Mockito.when(kardexService.save(Mockito.any(Kardex.class))).thenReturn(KARDEX_VALIDO);

		Exception thrown = assertThrows(CantidadInvalidaException.class, () -> sut.ventaProducto(COMPRA_PRODUCTO_DTO_CANTIDAD_INVALIDA_UP));

		assertEquals(thrown.getClass(), CantidadInvalidaException.class);

	}		
	
	@Test()
	public void ventaProducto_ConCompraVentaProductoValorInvalidoBajoLimite_throwException() throws Exception {
		Mockito.when(inventarioService.findByCodProducto(Mockito.anyLong())).thenReturn(INVENTARIO_VALID);
		Mockito.when(productoService.findByCodProducto(Mockito.anyLong())).thenReturn(PRODUCT_VALID);
		Mockito.when(productoService.save(Mockito.any(Producto.class))).thenReturn(PRODUCT_VALID);
		Mockito.when(tipoOperacionService.findByOperacion(TIPO_OPERACION_VALID.getOperacion())).thenReturn(TIPO_OPERACION_VALID);
		PowerMockito.whenNew(Kardex.class).withAnyArguments().thenReturn(KARDEX_VALIDO);
		Mockito.when(kardexService.save(Mockito.any(Kardex.class))).thenReturn(KARDEX_VALIDO);

		Exception thrown = assertThrows(ValorInvalidoException.class, () -> sut.compraProducto(COMPRA_PRODUCTO_DTO_VALOR_INVALIDA_DOWN));

		assertEquals(thrown.getClass(), ValorInvalidoException.class);

	}		
	@Test()
	public void ventaProducto_ConCompraVentaProductoValorInvalidoSobreLimite_throwException() throws Exception {
		Mockito.when(inventarioService.findByCodProducto(Mockito.anyLong())).thenReturn(INVENTARIO_VALID);
		Mockito.when(productoService.findByCodProducto(Mockito.anyLong())).thenReturn(PRODUCT_VALID);
		Mockito.when(productoService.save(Mockito.any(Producto.class))).thenReturn(PRODUCT_VALID);
		Mockito.when(tipoOperacionService.findByOperacion(TIPO_OPERACION_VALID.getOperacion())).thenReturn(TIPO_OPERACION_VALID);
		PowerMockito.whenNew(Kardex.class).withAnyArguments().thenReturn(KARDEX_VALIDO);
		Mockito.when(kardexService.save(Mockito.any(Kardex.class))).thenReturn(KARDEX_VALIDO);

		Exception thrown = assertThrows(ValorInvalidoException.class, () -> sut.ventaProducto(COMPRA_PRODUCTO_DTO_VALOR_INVALIDA_UP));

		assertEquals(thrown.getClass(), ValorInvalidoException.class);

	}			
	
	
}
