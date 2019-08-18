package com.todo1.hulkstore.services;

import com.todo1.hulkstore.model.TipoSuperheroe;

/**
 * Iterfaz de servicio de la entidad TipoSuperheroe
 * 
 * @author marfernandez
 *
 */
public interface TipoSuperheroeService {
	
	/**
	 * TipoSuperheroe Recupera un TipoSuperheroe por id del respositorio
	 * @return List<Inventario>
	 */
	public TipoSuperheroe findById(long id);
}
