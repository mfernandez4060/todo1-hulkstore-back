package com.todo1.hulkstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.hulkstore.exceptions.ProductoNotFoundException;
import com.todo1.hulkstore.model.Producto;
import com.todo1.hulkstore.respository.ProductoRepository;

/**
 * Implementacion de la iterfaz de servicio de la entidad Producto
 * 
 * @author marfernandez
 *
 */

@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(long id) {
		return productoRepository.findById(id).orElseThrow(() -> new ProductoNotFoundException(id));
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findByCodProducto(long codProducto) {
		return productoRepository.findByCodProducto(codProducto).orElseThrow(() -> new ProductoNotFoundException(codProducto));
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public void deleteById(Long id) {
		productoRepository.deleteById(id);
	}
}
