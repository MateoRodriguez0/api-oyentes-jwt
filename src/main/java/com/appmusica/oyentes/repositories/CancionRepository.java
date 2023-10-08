package com.appmusica.oyentes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appmusica.oyentes.models.Cancion;

/**
 * repositorio dao para realizar opercaciones con la entidad Cancion.
 * 
 * @Author Mateo Rodriguez
 *
 */
public interface CancionRepository extends JpaRepository<Cancion, Long> {

}
