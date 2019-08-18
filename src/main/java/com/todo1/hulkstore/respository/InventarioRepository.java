package com.todo1.hulkstore.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todo1.hulkstore.model.Inventario;

/**
 * Repositorio de datos de Inventario
 * 
 * @author marfernandez
 *
 */
@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {
	
	@Query("select i from Inventario i where i.producto.codProducto = :codProducto")
	Optional<Inventario> finByCodProducto(Long codProducto);

}
