package com.todo1.hulkstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.hulkstore.exceptions.InventarioNotFoundException;
import com.todo1.hulkstore.model.Inventario;
import com.todo1.hulkstore.respository.InventarioRepository;

/**
 * Implementacion de la iterfaz de servicio de la entidad Inventario
 * 
 * @author marfernandez
 *
 */

@Service
public class InventarioServiceImpl implements InventarioService {
	@Autowired
	private InventarioRepository inventarioRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Inventario> findAll() {
		return inventarioRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Inventario findById(long id) {
		return inventarioRepository.findById(id).orElseThrow(() -> new InventarioNotFoundException(id));
	}
	@Transactional(readOnly = true)
	public Inventario findByCodProducto(Long codProducto) {
		return inventarioRepository.finByCodProducto(codProducto).orElseThrow(() -> new InventarioNotFoundException(codProducto));
	}

	@Transactional
	@Override
	public Inventario save(Inventario inventario) {
		return inventarioRepository.save(inventario);
	}
	@Transactional
	@Override
	public void delete(Inventario invantario) {
		inventarioRepository.delete(invantario);
		
	}
}
