package com.todo1.hulkstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.hulkstore.exceptions.TipoOperacionNotFoundException;
import com.todo1.hulkstore.model.TipoOperacion;
import com.todo1.hulkstore.model.TipoOperacion.Operacion;
import com.todo1.hulkstore.respository.TipoOperacionRepository;

/**
 * Implementacion de la iterfaz de servicio de la entidad Producto
 * 
 * @author marfernandez
 *
 */

@Service
public class TipoOperacionServiceImpl implements TipoOperacionService {
	@Autowired
	private TipoOperacionRepository tipoOperacionRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<TipoOperacion> findAll() {
		return tipoOperacionRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public TipoOperacion findById(long id) {
		return tipoOperacionRepository.findById(id).orElseThrow(() -> new TipoOperacionNotFoundException(id));
	}

	@Transactional(readOnly = true)
	@Override
	public TipoOperacion findByOperacion(Operacion operacion) {
		return tipoOperacionRepository.findByOperacion(operacion).orElseThrow(() -> new TipoOperacionNotFoundException(operacion));
	}
}
