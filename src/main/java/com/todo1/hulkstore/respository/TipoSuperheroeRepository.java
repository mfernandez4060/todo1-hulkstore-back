package com.todo1.hulkstore.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo1.hulkstore.model.TipoSuperheroe;

/**
 * Repositorio de datos de TipoSuperheroe
 * 
 * @author marfernandez
 *
 */
@Repository
public interface TipoSuperheroeRepository extends JpaRepository<TipoSuperheroe, Long> {

}
