package com.todo1.hulkstore.controller.rest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
import com.todo1.hulkstore.controller.rest.KardexController;
import com.todo1.hulkstore.dtos.KardexDto;
import com.todo1.hulkstore.model.Kardex;
import com.todo1.hulkstore.model.TipoOperacion;
import com.todo1.hulkstore.services.KardexService;
/**
 * Test de KardexController
 * @author mariano
 *
 */
@RunWith(SpringRunner.class)
@EnableConfigurationProperties
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class KardexControllerTest {
	private static final KardexDto KARDEX_DTO_VALID = Mockito.mock(KardexDto.class);
	private static final Collection<Kardex> COLLECTION_KARDEX_VALIDO = new ArrayList<>();
	private static final Collection<Kardex> COLLECTION_KARDEX_EMPTY = new ArrayList<>();
	private static final Kardex KARDEX_VALIDO=TestHelper.buildKardex(1, new Timestamp(System.currentTimeMillis()),
			TestHelper.buildProducto(1L, 1L, "Tasa Hulk", TestHelper.buildTipoSuperheroe(1, "Marvel"),100.0), TestHelper.buildTipoOperacion(1L,"Compra articulos",TipoOperacion.Operacion.COMPRA), 100.0, 10);;


	@BeforeEach
	void init() {
		COLLECTION_KARDEX_VALIDO.add(KARDEX_VALIDO);
	}

	@AfterEach
	void tearDown() {
	}
	
	@Mock
	private KardexDto kardexDto;

	@Mock
	private Kardex kardex;
	
	@Mock
	private KardexService kardexService;
	
	@InjectMocks
	private KardexController sut;
	
	@Test()
	public void findAllKardexByCodProducto_conParametroValido_returnaValidListKardexDto() throws Exception {
		PowerMockito.whenNew(KardexDto.class).withAnyArguments().thenReturn(KARDEX_DTO_VALID);
		Mockito.when(kardexService.findByCodProductoOrderByFecha(Mockito.anyLong())).thenReturn(COLLECTION_KARDEX_VALIDO);
		List<KardexDto> response = sut.findAllKardexByCodProducto(Mockito.anyLong());

		Mockito.verify(kardexService, Mockito.times(1)).findByCodProductoOrderByFecha(Mockito.anyLong());
		assertTrue(response.size()> 0);
	}
	
	@Test()
	public void findAllKardexByCodProducto_conCodProductoNoValido_returnaKardexDtoVacio() throws Exception {
		PowerMockito.whenNew(KardexDto.class).withAnyArguments().thenReturn(KARDEX_DTO_VALID);
		Mockito.when(kardexService.findByCodProductoOrderByFecha(Mockito.anyLong())).thenReturn(COLLECTION_KARDEX_EMPTY);
		List<KardexDto> response = sut.findAllKardexByCodProducto(Mockito.anyLong());

		Mockito.verify(kardexService, Mockito.times(1)).findByCodProductoOrderByFecha(Mockito.anyLong());
		assertEquals(response.size(), 0);
	}	

}
