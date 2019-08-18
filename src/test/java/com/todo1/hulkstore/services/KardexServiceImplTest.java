package com.todo1.hulkstore.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.todo1. hulckstore.helper.TestHelper;
import com.todo1.hulkstore.exceptions.KardexNotFoundException;
import com.todo1.hulkstore.model.Kardex;
import com.todo1.hulkstore.model.TipoOperacion;
import com.todo1.hulkstore.respository.KardexRepository;

@RunWith(SpringRunner.class)
@EnableConfigurationProperties
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class KardexServiceImplTest {
	private static final long ID_VALIDO = 1;
	private static final long ID_VALIDO_INEXISTENTE = 0;
	private List<Kardex> LISTA_DE_KARDEX;
	private ArrayList<Kardex> LISTA_DE_KARDEX_EMPTY;
	private static final Optional<Kardex> KARDEX_VALIDO = Optional.of(TestHelper.buildKardex(1, new Timestamp(System.currentTimeMillis()),
			TestHelper.buildProducto(1L, 1L, "Tasa Hulk", TestHelper.buildTipoSuperheroe(1, "Marvel"),100.0), TestHelper.buildTipoOperacion(1L,"Compra articulos",TipoOperacion.Operacion.COMPRA), 100.0, 10));
	private static final Optional<Kardex> KARDEX_INVALIDO = Optional.empty();

	@BeforeEach
	public void setUp() {
		LISTA_DE_KARDEX_EMPTY = new ArrayList<Kardex>();
		LISTA_DE_KARDEX = new ArrayList<Kardex>();
		LISTA_DE_KARDEX.add(KARDEX_VALIDO.get());
	}

	@AfterEach
	public void tearDown() {
	}

	@Mock
	private KardexRepository KardexRepository;

	@InjectMocks
	private KardexServiceImpl sut;

	@Test
	void findById_conIDValido_retornaUnKARDEXValido() {
		Mockito.when(KardexRepository.findById(ID_VALIDO)).thenReturn(KARDEX_VALIDO);
		Kardex response = sut.findById(ID_VALIDO);
		Mockito.verify(KardexRepository, Mockito.times(1)).findById(ID_VALIDO);

		assertEquals(KARDEX_VALIDO.get(), response);
	}

	@Test
	void findById_conIDNOValido_retornaUnException() {
		Mockito.when(KardexRepository.findById(ID_VALIDO_INEXISTENTE)).thenReturn(KARDEX_INVALIDO);

		Exception thrown = assertThrows(KardexNotFoundException.class, () -> sut.findById(ID_VALIDO_INEXISTENTE));

		assertEquals(thrown.getClass(), KardexNotFoundException.class);
	}
}
