package com.todo1.hulkstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.hulkstore.exceptions.TipoSuperheroeNotFoundException;
import com.todo1.hulkstore.model.TipoSuperheroe;
import com.todo1.hulkstore.respository.TipoSuperheroeRepository;

/**
 * Implementacion de la iterfaz de servicio de la entidad Producto
 * 
 * @author marfernandez
 *
 */

@Service
public class TipoSuperheroeServiceImpl implements TipoSuperheroeService {
	@Autowired
	private TipoSuperheroeRepository tipoSuperheroeRepository;
	
	@Transactional(readOnly = true)
	@Override
	public TipoSuperheroe findById(long id) {
		return tipoSuperheroeRepository.findById(id).orElseThrow(() -> new TipoSuperheroeNotFoundException(id));
	}
}
