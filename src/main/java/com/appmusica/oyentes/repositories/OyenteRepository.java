package com.appmusica.oyentes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appmusica.oyentes.models.Oyente;

/**
 * repositorio dao para realizar opercaciones con la entidad Oyente.
 * 
 * @Author Mateo Rodriguez
 *
 */
public interface OyenteRepository extends JpaRepository<Oyente, Long> {

	
}
