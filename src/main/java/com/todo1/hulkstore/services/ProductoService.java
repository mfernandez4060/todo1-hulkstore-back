package com.todo1.hulkstore.services;

import java.util.List;

import com.todo1.hulkstore.model.Producto;

/**
 * Iterfaz de servicio de la entidad Producto
 * 
 * @author marfernandez
 *
 */
public interface ProductoService {
	
	/**
	 * findAll Recupera el Producto completo del respositorio
	 * @return List<Inventario>
	 */
	public List<Producto> findAll();

	/**
	 * findById Recupera un Producto por id del respositorio
	 * @return List<Inventario>
	 */
	public Producto findById(long id);
	
	/**
	 * findByCodProducto Recupera un Producto por codProducto del respositorio
	 * @return List<Inventario>
	 */
	public Producto findByCodProducto(long codProducto);

	/**
	 * save Persiste un Producto en el respositorio
	 * 
	 */
	public Producto save(Producto producto);

	/**
	 * delete Elimina un Producto en el respositorio
	 * 
	 */
	public void deleteById(Long id);
}
