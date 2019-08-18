package com.todo1.hulkstore.services;

import java.util.List;

import com.todo1.hulkstore.model.TipoOperacion;
import com.todo1.hulkstore.model.TipoOperacion.Operacion;

/**
 * Iterfaz de servicio de la entidad TipoOperacion
 * 
 * @author marfernandez
 *
 */
public interface TipoOperacionService {
	
	/**
	 * Recupera el TipoOperacion completo del respositorio
	 * @return List<Inventario>
	 */
	public List<TipoOperacion> findAll();

	/**
	 * findById Recupera un TipoOperacion por id del respositorio
	 * @return List<Inventario>
	 */
	public TipoOperacion findById(long id);
	
	/**
	 * 
	 * findById Recupera un TipoOperacion por operacion
	 * @return List<Inventario>
	 */
	public TipoOperacion findByOperacion(Operacion operacion);
}
