package com.todo1.hulkstore.controller.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.todo1.hulckstore.helper.TestHelper;
import com.todo1.hulkstore.dtos.ProductoDto;
import com.todo1.hulkstore.model.Inventario;
import com.todo1.hulkstore.model.Producto;
import com.todo1.hulkstore.services.InventarioService;
import com.todo1.hulkstore.services.ProductoService;
import com.todo1.hulkstore.services.TipoSuperheroeService;

/**
 * Test de Productos
 * 
 * @author mariano
 *
 */
@RunWith(SpringRunner.class)
@EnableConfigurationProperties
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductosControllerTest {

	private static final Producto PRODUCTO_VALIDO = TestHelper.buildProducto(1L, 1L, "Tasa Hulk",
			TestHelper.buildTipoSuperheroe(1, "Marvel"), 100.0);
	private static final Inventario INVENTARIO_VALIDO = TestHelper.buildInventario(1L, PRODUCTO_VALIDO, 1L, new Timestamp(System.currentTimeMillis()));
	private static ProductoDto PRODUCTO_DTO_VALIDO = null;
	@BeforeEach
	void init() {
		PRODUCTO_DTO_VALIDO = modelMapper.map(PRODUCTO_VALIDO, ProductoDto.class);
	}

	@AfterEach
	void tearDown() {
	}

	@Mock
	private ProductoService productoService;

	@Mock
	private TipoSuperheroeService tipoSuperheroeService;

	@Mock
	private InventarioService inventarioService;
	
	@Mock
	ModelMapper mockModelMapper;
	
	@Autowired
	ModelMapper modelMapper;

	@InjectMocks
	private ProductosController sut;

	@Test()
	public void findProductoByCodProducto_conCodProductoValido_returnaProductoDtoValido() throws Exception {
		Mockito.when(productoService.findByCodProducto(Mockito.anyLong())).thenReturn(PRODUCTO_VALIDO);
		Mockito.when(mockModelMapper.map(PRODUCTO_VALIDO, ProductoDto.class)).thenReturn( modelMapper.map(PRODUCTO_VALIDO, ProductoDto.class));
		ProductoDto response = sut.findProductoByCodProducto(Mockito.anyLong());

		Mockito.verify(productoService, Mockito.times(1)).findByCodProducto(Mockito.anyLong());

		assertEquals(response.getCodProducto(), PRODUCTO_VALIDO.getCodProducto());
	}
	
	@Test()
	public void addProducto_conCodProductoValido_returnaProductoDtoValido() throws Exception {
		Mockito.when(productoService.findByCodProducto(Mockito.anyLong())).thenReturn(PRODUCTO_VALIDO);
		Mockito.when(mockModelMapper.map(PRODUCTO_VALIDO, ProductoDto.class)).thenReturn(modelMapper.map(PRODUCTO_VALIDO, ProductoDto.class));
		ProductoDto response = sut.findProductoByCodProducto(Mockito.anyLong());

		Mockito.verify(productoService, Mockito.times(1)).findByCodProducto(Mockito.anyLong());

		assertEquals(response.getCodProducto(), PRODUCTO_VALIDO.getCodProducto());
	}
	
	
	@Test()
	public void persistirProducto_conCodProductoValido_returnaProductoDtoValido() throws Exception {
		Mockito.when(productoService.save(PRODUCTO_VALIDO)).thenReturn(PRODUCTO_VALIDO);
		Mockito.when(mockModelMapper.map(PRODUCTO_DTO_VALIDO, Producto.class)).thenReturn(modelMapper.map(PRODUCTO_DTO_VALIDO, Producto.class));
		Mockito.when(mockModelMapper.map(PRODUCTO_VALIDO, ProductoDto.class)).thenReturn(modelMapper.map(PRODUCTO_VALIDO, ProductoDto.class));	
		sut.persistirProducto(PRODUCTO_DTO_VALIDO);

		Mockito.verify(productoService, Mockito.times(1)).save(Mockito.any(Producto.class));
		Mockito.verify(inventarioService, Mockito.times(1)).save(Mockito.any(Inventario.class));
	}
	
	@Test()
	public void updateProductoById_conCodProductoValido_returnaProductoDtoValido() throws Exception {
		Mockito.when(productoService.findById(Mockito.anyLong())).thenReturn(PRODUCTO_VALIDO);
		Mockito.when(productoService.save(PRODUCTO_VALIDO)).thenReturn(PRODUCTO_VALIDO);
		Mockito.when(mockModelMapper.map(PRODUCTO_VALIDO, ProductoDto.class)).thenReturn(modelMapper.map(PRODUCTO_VALIDO, ProductoDto.class));		
		ProductoDto response = sut.updateProductoById(Mockito.anyLong(),PRODUCTO_DTO_VALIDO);

		Mockito.verify(tipoSuperheroeService, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(productoService, Mockito.times(1)).save(PRODUCTO_VALIDO);

		assertEquals(response.getCodProducto(), PRODUCTO_VALIDO.getCodProducto());
	}
	
	@Test()
	public void deleteProductoById_conCodProductoValido_returnaProductoDtoValido() throws Exception {
		Mockito.when(productoService.findById(Mockito.anyLong())).thenReturn(PRODUCTO_VALIDO);
		Mockito.when(inventarioService.findByCodProducto(Mockito.anyLong())).thenReturn(INVENTARIO_VALIDO);
		sut.deleteProductoById(Mockito.anyLong());

		Mockito.verify(productoService, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(inventarioService, Mockito.times(1)).delete(INVENTARIO_VALIDO);
	}	

}
