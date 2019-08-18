package com.todo1.hulkstore.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo1.hulkstore.model.TipoOperacion;
import com.todo1.hulkstore.model.TipoOperacion.Operacion;

/**
 * Repositorio de datos de TipoOperacion
 * 
 * @author marfernandez
 *
 */
@Repository
public interface TipoOperacionRepository extends JpaRepository<TipoOperacion, Long> {

	Optional<TipoOperacion> findByOperacion(Operacion operacion);

}
