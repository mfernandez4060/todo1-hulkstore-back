package com.todo1.hulkstore.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.todo1. hulckstore.helper.TestHelper;
import com.todo1.hulkstore.exceptions.InventarioNotFoundException;
import com.todo1.hulkstore.model.Inventario;
import com.todo1.hulkstore.respository.InventarioRepository;

@SpringBootTest
public class InventarioServiceImplTest {
	private static final long ID_VALIDO = 1L;
	private List<Inventario> LISTA_DE_INVENTARIO;
	private ArrayList<Inventario> LISTA_DE_INVENTARIO_VACIA;
	private static final Optional<Inventario> INVENTARIO_VALIDO = Optional.of(TestHelper.buildInventario(1, TestHelper.buildProducto(1, 1, "Tasa Hulk",TestHelper.buildTipoSuperheroe(1, "Marvel"),100.00), 1, new Date()));
	private static final Optional<Inventario> INVENTARIO_INVALIDO = Optional.empty();

	@BeforeEach
	public void setUp() {
		LISTA_DE_INVENTARIO_VACIA = new ArrayList<Inventario>();
		LISTA_DE_INVENTARIO = new ArrayList<Inventario>();
		LISTA_DE_INVENTARIO.add(INVENTARIO_VALIDO.get());
	}

	@AfterEach
	public void tearDown() {
	}

	@Mock
	private InventarioRepository inventarioRepository;
	
	@InjectMocks
	private InventarioServiceImpl sut;

	@Test
	void findAll_sinParametros_retornaListaDeInventario() {
		Mockito.when(inventarioRepository.findAll()).thenReturn(LISTA_DE_INVENTARIO);
		Mockito.when(sut.findAll()).thenReturn(LISTA_DE_INVENTARIO);
		List<Inventario> response = sut.findAll();
		Mockito.verify(inventarioRepository, Mockito.times(1)).findAll();
		
		assertEquals(LISTA_DE_INVENTARIO, response);
	}
	
	@Test
	void findAll_sinParametros_retornaListaVacia() {
		Mockito.when(inventarioRepository.findAll()).thenReturn(LISTA_DE_INVENTARIO_VACIA);
		Mockito.when(sut.findAll()).thenReturn(LISTA_DE_INVENTARIO);
		List<Inventario> response = sut.findAll();
		Mockito.verify(inventarioRepository, Mockito.times(1)).findAll();
		
		assertEquals(LISTA_DE_INVENTARIO, response);
	}
	
	@Test
	void findById_conIdValido_retornaUnInventarioValido() {
		Mockito.when(inventarioRepository.findById(ID_VALIDO)).thenReturn(INVENTARIO_VALIDO);
		Inventario response = sut.findById(ID_VALIDO);
		Mockito.verify(inventarioRepository, Mockito.times(1)).findById(ID_VALIDO);
		
		assertEquals(INVENTARIO_VALIDO.get(), response);
	}	
	
	@Test
	void findById_conIdNOValido_retornaUnException() {
		Mockito.when(inventarioRepository.findById(Mockito.anyLong())).thenReturn(INVENTARIO_INVALIDO);
		
		Exception thrown = assertThrows(InventarioNotFoundException.class,
				() -> sut.findById(Mockito.anyLong()));

		assertEquals(thrown.getClass(), InventarioNotFoundException.class);
	}	
}
