package com.todo1.hulkstore.controller.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.todo1.hulkstore.controller.rest.InventarioController;
import com.todo1.hulkstore.dtos.InventarioDto;
import com.todo1.hulkstore.model.Inventario;
import com.todo1.hulkstore.services.InventarioService;
/**
 * Test de InventarioController
 * @author mariano
 *
 */
@RunWith(SpringRunner.class)
@EnableConfigurationProperties
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class InventarioControllerTest {

	private static List<Inventario> VALID_LIST_INVENTARIO = null;
	private static List<Inventario> EMPTY_LIST_INVENTARIO = null;

	@LocalServerPort
	private int _port;

	@BeforeEach
	void init() {
		VALID_LIST_INVENTARIO = new ArrayList<>();
		VALID_LIST_INVENTARIO.add(Mockito.mock(Inventario.class));
		EMPTY_LIST_INVENTARIO = new ArrayList<>();
	}

	@AfterEach
	void tearDown() {
	}

	@Mock
	private InventarioService inventarioService;

	@Mock
	ModelMapper modelMapper;

	@InjectMocks
	private InventarioController sut;

	@Test
	public void findAllInventario_withResult_returnValidListInventarioDto() throws Exception {
		Mockito.when(inventarioService.findAll()).thenReturn(VALID_LIST_INVENTARIO);
		List<InventarioDto> response = sut.findAllInventario();

		Mockito.verify(inventarioService, Mockito.times(1)).findAll();
		assertEquals(response.size(), 1);
	}

	@Test
	public void findAllInventario_withoutResult_returnValidListInventarioDto() throws Exception {
		Mockito.when(inventarioService.findAll()).thenReturn(EMPTY_LIST_INVENTARIO);
		List<InventarioDto> response = sut.findAllInventario();

		Mockito.verify(inventarioService, Mockito.times(1)).findAll();
		assertEquals(response.size(), 0);
	}

}