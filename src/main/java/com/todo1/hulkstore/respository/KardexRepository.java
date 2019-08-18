package com.todo1.hulkstore.respository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todo1.hulkstore.model.Kardex;

/**
 * Repositorio de datos de Kardex
 * 
 * @author marfernandez
 *
 */
@Repository
public interface KardexRepository extends JpaRepository<Kardex, Long> {

	@Query("select k from Kardex k where k.producto.codProducto=:codProducto order by k.fecha")
	public Collection<Kardex> findByCodProductoOrderByFecha(long codProducto);

}
