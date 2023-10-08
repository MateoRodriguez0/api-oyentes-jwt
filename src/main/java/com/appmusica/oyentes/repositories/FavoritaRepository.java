package com.appmusica.oyentes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appmusica.oyentes.models.Favorita;



/**
 * repositorio dao para realizar opercaciones con la entidad Favorita.
 * 
 * @Author Mateo Rodriguez
 *
 */
public interface FavoritaRepository extends JpaRepository<Favorita,Long> {


}
