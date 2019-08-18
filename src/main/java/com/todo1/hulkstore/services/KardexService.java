package com.todo1.hulkstore.services;

import java.util.Collection;

import com.todo1.hulkstore.model.Kardex;

/**
 * Iterfaz de servicio de la entidad Kardex
 * 
 * @author marfernandez
 *
 */
public interface KardexService {
	
	/**
	 * Recupera un Kardex por id del respositorio
	 * @return Kardex
	 */
	public Kardex findById(long id);

	/**
	 * save Persiste una entidad Kardex
	 * @return Kardex
	 */
	public Kardex save(Kardex kardex);

	/**
	 * findByCodProductoOrderByFecha Recupera un Kardex por codigo de producto ordenado por fecha
	 * @return List<Kardex> 
	 */

	public Collection<Kardex> findByCodProductoOrderByFecha(long codProducto);
}
