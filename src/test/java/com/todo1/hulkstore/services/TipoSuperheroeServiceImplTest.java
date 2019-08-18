package com.todo1.hulkstore.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.todo1. hulckstore.helper.TestHelper;
import com.todo1.hulkstore.exceptions.TipoSuperheroeNotFoundException;
import com.todo1.hulkstore.model.TipoSuperheroe;
import com.todo1.hulkstore.respository.TipoSuperheroeRepository;

@SpringBootTest
public class TipoSuperheroeServiceImplTest {
	private static final long ID_VALIDO = 1;
	private static final long ID_VALIDO_INEXISTENTE = 0;
	
	private static final Optional<TipoSuperheroe> TIPO_SUPERHEROE_VALIDO = Optional.of(TestHelper.buildTipoSuperheroe(1, "Hulk"));
	private static final Optional<TipoSuperheroe> TIPO_SUPERHEROE_INVALIDO = Optional.empty();

	@BeforeEach
	public void setUp() {
	}

	@AfterEach
	public void tearDown() {
	}

	@Mock
	private TipoSuperheroeRepository TipoSuperheroeRepository;

	@InjectMocks
	private TipoSuperheroeServiceImpl sut;

	@Test
	void findById_conIDValido_retornaUnTIPO_SUPERHEROEValido() {
		Mockito.when(TipoSuperheroeRepository.findById(ID_VALIDO)).thenReturn(TIPO_SUPERHEROE_VALIDO);
		TipoSuperheroe response = sut.findById(ID_VALIDO);
		Mockito.verify(TipoSuperheroeRepository, Mockito.times(1)).findById(ID_VALIDO);

		assertEquals(TIPO_SUPERHEROE_VALIDO.get(), response);
	}

	@Test
	void findById_conIdNoValido_retornaUnException() {
		Mockito.when(TipoSuperheroeRepository.findById(ID_VALIDO_INEXISTENTE)).thenReturn(TIPO_SUPERHEROE_INVALIDO);

		Exception thrown = assertThrows(TipoSuperheroeNotFoundException.class, () -> sut.findById(ID_VALIDO_INEXISTENTE));

		assertEquals(thrown.getClass(), TipoSuperheroeNotFoundException.class);
	}
}
