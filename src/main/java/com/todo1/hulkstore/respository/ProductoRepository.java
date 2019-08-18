package com.todo1.hulkstore.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo1.hulkstore.model.Producto;

/**
 * Repositorio de datos de Producto
 * 
 * @author marfernandez
 *
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	Optional<Producto> findByCodProducto(long codProducto);

}
