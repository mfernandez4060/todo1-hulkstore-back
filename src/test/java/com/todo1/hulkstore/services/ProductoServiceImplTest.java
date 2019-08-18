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
import com.todo1.hulkstore.exceptions.ProductoNotFoundException;
import com.todo1.hulkstore.model.Producto;
import com.todo1.hulkstore.respository.ProductoRepository;

@SpringBootTest
public class ProductoServiceImplTest {
	private static final long ID_VALIDO = 1;
	private static final long ID_VALIDO_INEXISTENTE = 0;
	private List<Producto> LISTA_DE_PRODUCTO;
	private ArrayList<Producto> LISTA_DE_PRODUCTO_EMPTY;
	
	private static final Optional<Producto> PRODUCTO_VALIDO = Optional.of(TestHelper.buildProducto(1L, 1L, "Tasa Hulk", TestHelper.buildTipoSuperheroe(1, "Marvel"), 100.0));
	private static final Optional<Producto> PRODUCTO_INVALIDO = Optional.empty();

	@BeforeEach
	public void setUp() {
		LISTA_DE_PRODUCTO_EMPTY = new ArrayList<Producto>();
		LISTA_DE_PRODUCTO = new ArrayList<Producto>();
		LISTA_DE_PRODUCTO.add(PRODUCTO_VALIDO.get());
	}

	@AfterEach
	public void tearDown() {
	}

	@Mock
	private ProductoRepository ProductoRepository;

	@InjectMocks
	private ProductoServiceImpl sut;

	@Test
	void findAll_sinParámetros_retornaListaDeProductos() {
		Mockito.when(ProductoRepository.findAll()).thenReturn(LISTA_DE_PRODUCTO);
		Mockito.when(sut.findAll()).thenReturn(LISTA_DE_PRODUCTO);
		List<Producto> response = sut.findAll();
		Mockito.verify(ProductoRepository, Mockito.times(1)).findAll();

		assertEquals(LISTA_DE_PRODUCTO, response);
	}

	@Test
	void findAll_sinParámetros_retornaListaVacia() {
		Mockito.when(ProductoRepository.findAll()).thenReturn(LISTA_DE_PRODUCTO_EMPTY);
		Mockito.when(sut.findAll()).thenReturn(LISTA_DE_PRODUCTO);
		List<Producto> response = sut.findAll();
		Mockito.verify(ProductoRepository, Mockito.times(1)).findAll();

		assertEquals(LISTA_DE_PRODUCTO, response);
	}

	@Test
	void findById_conIDValido_retornaUnPRODUCTOValido() {
		Mockito.when(ProductoRepository.findById(ID_VALIDO)).thenReturn(PRODUCTO_VALIDO);
		Producto response = sut.findById(ID_VALIDO);
		Mockito.verify(ProductoRepository, Mockito.times(1)).findById(ID_VALIDO);

		assertEquals(PRODUCTO_VALIDO.get(), response);
	}

	@Test
	void findById_conIDNOValido_retornaUnException() {
		Mockito.when(ProductoRepository.findById(ID_VALIDO_INEXISTENTE)).thenReturn(PRODUCTO_INVALIDO);

		Exception thrown = assertThrows(ProductoNotFoundException.class, () -> sut.findById(ID_VALIDO_INEXISTENTE));

		assertEquals(thrown.getClass(), ProductoNotFoundException.class);
	}
}
