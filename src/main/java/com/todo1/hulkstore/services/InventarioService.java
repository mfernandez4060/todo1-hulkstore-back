package com.todo1.hulkstore.services;

import java.util.List;

import com.todo1.hulkstore.model.Inventario;

/**
 * Iterfaz de servicio de la entidad Inventario
 * 
 * @author marfernandez
 *
 */
public interface InventarioService {
	
	/**
	 * Recupera el inventario completo del respositorio
	 * @return List<Inventario>
	 */
	public List<Inventario> findAll();

	/**
	 * Recupera un inventario por id del respositorio
	 * @return List<Inventario>
	 */
	public Inventario findById(long id);

	/**
	 * Recupera un inventario por codigo de producto del respositorio
	 * @param codProducto
	 * @return
	 */
	public Inventario findByCodProducto(Long codProducto);

	/**
	 * Presiste un inventario
	 * @param inventario
	 * @return
	 */
	public Inventario save(Inventario inventario);

	/**
	 * Elimina un inventario
	 * @param inventario
	 * @return
	 */
	public void delete(Inventario invantario);
}
