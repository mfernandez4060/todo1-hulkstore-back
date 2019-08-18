package com.todo1.hulkstore.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
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
import com.todo1.hulkstore.exceptions.TipoOperacionNotFoundException;
import com.todo1.hulkstore.model.TipoOperacion;
import com.todo1.hulkstore.model.TipoOperacion.Operacion;
import com.todo1.hulkstore.respository.TipoOperacionRepository;

@SpringBootTest
public class TipoOperacionServiceImplTest {
	private static final long ID_VALIDO = 1;
	private static final long ID_VALIDO_INEXISTENTE = 0;
	private List<TipoOperacion> LISTA_DE_TIPO_OPERACION;
	private ArrayList<TipoOperacion> LISTA_DE_TIPO_OPERACION_EMPTY;
	
	private static final Optional<TipoOperacion> TIPO_OPERACION_VALIDO = Optional.of(TestHelper.buildTipoOperacion(1L, "COMPRA", Operacion.COMPRA));
	private static final Optional<TipoOperacion> TIPO_OPERACION_INVALIDO = Optional.empty();

	@BeforeEach
	public void setUp() {
		LISTA_DE_TIPO_OPERACION_EMPTY = new ArrayList<TipoOperacion>();
		LISTA_DE_TIPO_OPERACION = new ArrayList<TipoOperacion>();
		LISTA_DE_TIPO_OPERACION.add(TIPO_OPERACION_VALIDO.get());
	}

	@AfterEach
	public void tearDown() {
	}

	@Mock
	private TipoOperacionRepository TipoOperacionRepository;

	@InjectMocks
	private TipoOperacionServiceImpl sut;

	@Test
	void findAll_sinParámetros_retornaListaDeTipoOperacions() {
		Mockito.when(TipoOperacionRepository.findAll()).thenReturn(LISTA_DE_TIPO_OPERACION);
		Mockito.when(sut.findAll()).thenReturn(LISTA_DE_TIPO_OPERACION);
		List<TipoOperacion> response = sut.findAll();
		Mockito.verify(TipoOperacionRepository, Mockito.times(1)).findAll();

		assertEquals(LISTA_DE_TIPO_OPERACION, response);
	}

	@Test
	void findAll_sinParámetros_retornaListaVacia() {
		Mockito.when(TipoOperacionRepository.findAll()).thenReturn(LISTA_DE_TIPO_OPERACION_EMPTY);
		Mockito.when(sut.findAll()).thenReturn(LISTA_DE_TIPO_OPERACION);
		List<TipoOperacion> response = sut.findAll();
		Mockito.verify(TipoOperacionRepository, Mockito.times(1)).findAll();

		assertEquals(LISTA_DE_TIPO_OPERACION, response);
	}

	@Test
	void findById_conIDValido_retornaUnTIPO_OPERACIONValido() {
		Mockito.when(TipoOperacionRepository.findById(ID_VALIDO)).thenReturn(TIPO_OPERACION_VALIDO);
		TipoOperacion response = sut.findById(ID_VALIDO);
		Mockito.verify(TipoOperacionRepository, Mockito.times(1)).findById(ID_VALIDO);

		assertEquals(TIPO_OPERACION_VALIDO.get(), response);
	}

	@Test
	void findById_conIDNOValido_retornaUnException() {
		Mockito.when(TipoOperacionRepository.findById(ID_VALIDO_INEXISTENTE)).thenReturn(TIPO_OPERACION_INVALIDO);

		Exception thrown = assertThrows(TipoOperacionNotFoundException.class, () -> sut.findById(ID_VALIDO_INEXISTENTE));

		assertEquals(thrown.getClass(), TipoOperacionNotFoundException.class);
	}
}
