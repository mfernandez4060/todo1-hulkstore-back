package com.todo1.hulkstore.controller.rest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.todo1.hulckstore.helper.TestHelper;
import com.todo1.hulkstore.controller.bo.OperacionesBo;
import com.todo1.hulkstore.dtos.CompraVentaProductoDto;
/**
 * Test de OperacionesController
 * @author mariano
 *
 */
@RunWith(SpringRunner.class)
@EnableConfigurationProperties
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OperacionesControllerTest {

	private static final CompraVentaProductoDto COMPRA_PRODUCTO_DTO_VALIDO = TestHelper.buildCompraProducto(1L,1001L,10.23);

	@BeforeEach
	void init() {
	}

	@AfterEach
	void tearDown() {
	}
	
	@Mock
	private OperacionesBo operacionesBo;

	@InjectMocks
	private OperacionesController sut;
	
	@Test()
	public void compraProducto_conParametroValido_NoRetornaException() throws Exception {
		sut.compraProducto(COMPRA_PRODUCTO_DTO_VALIDO);

		Mockito.verify(operacionesBo, Mockito.times(1)).compraProducto(COMPRA_PRODUCTO_DTO_VALIDO);
	}
	
	@Test()
	public void ventaProducto_conParametroValido_NoRetornaException() throws Exception {
		sut.ventaProducto(COMPRA_PRODUCTO_DTO_VALIDO);

		Mockito.verify(operacionesBo, Mockito.times(1)).ventaProducto(COMPRA_PRODUCTO_DTO_VALIDO);
	}
	
}
