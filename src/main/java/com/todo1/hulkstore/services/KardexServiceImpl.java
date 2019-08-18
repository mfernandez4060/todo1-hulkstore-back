package com.todo1.hulkstore.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.hulkstore.exceptions.KardexNotFoundException;
import com.todo1.hulkstore.model.Kardex;
import com.todo1.hulkstore.respository.KardexRepository;

/**
 * Implementacion de la iterfaz de servicio de la entidad Kardex
 * 
 * @author marfernandez
 *
 */

@Service
public class KardexServiceImpl implements KardexService {
	@Autowired
	private KardexRepository kardexRepository;
	
	@Transactional(readOnly = true)
	@Override
	public Kardex findById(long id) {
		return kardexRepository.findById(id).orElseThrow(() -> new KardexNotFoundException(id));
	}

	@Transactional
	@Override
	public Kardex save(Kardex kardex) {
		return kardexRepository.save(kardex);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Kardex> findByCodProductoOrderByFecha(long codProducto) {
		return kardexRepository.findByCodProductoOrderByFecha(codProducto);
	}
}
