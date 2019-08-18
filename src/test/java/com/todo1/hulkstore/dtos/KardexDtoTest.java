package com.todo1.hulkstore.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.todo1.hulckstore.helper.TestHelper;
import com.todo1.hulkstore.model.Kardex;
import com.todo1.hulkstore.model.TipoOperacion;

public class KardexDtoTest {
	private static final Kardex KARDEX_VALIDO = TestHelper.buildKardex(1, new Timestamp(System.currentTimeMillis()),
			TestHelper.buildProducto(1L, 1L, "Tasa Hulk", TestHelper.buildTipoSuperheroe(1, "Marvel"), 100.0),
			TestHelper.buildTipoOperacion(1L, "Compra articulos", TipoOperacion.Operacion.COMPRA), 100.0, 10);

	@BeforeEach
	public void setUp() {
	}

	@AfterEach
	public void tearDown() {
	}

	@Test
	void procesaSaldos_conKardexValidoSaldoCero_retornaVoid() {
		CantidadTotal saldo = new CantidadTotal(0, 0.0);
		KardexDto kardexDto = new KardexDto(KARDEX_VALIDO, saldo);

		kardexDto.procesaSaldos(KARDEX_VALIDO, saldo, kardexDto);

		assertEquals(10L, kardexDto.getSaldo().getCantidad());
		assertEquals(-1000.0, kardexDto.getSaldo().getTotal());

	}

	@Test
	void procesaSaldos_conKardexValidoSaldoDiferenteaCero_retornaVoid() {
		CantidadTotal saldo = new CantidadTotal(10, -1000.0);
		KardexDto kardexDto = new KardexDto(KARDEX_VALIDO, saldo);

		kardexDto.procesaSaldos(KARDEX_VALIDO, saldo, kardexDto);

		assertEquals(20,kardexDto.getSaldo().getCantidad());
		assertEquals(-2000, kardexDto.getSaldo().getTotal());

	}
}
