package com.appmusica.oyentes.services;

import java.util.List;
import com.appmusica.oyentes.models.Favorita;

/**
 * interfaz que provee los servicios que seran necesarios para implementar la logica de negocio
 */
public interface OyenteServices {

	/**
	 * busca el cliente y obtiene las canciones que se encuentran en la lista de favoritas de un oyente
	 * 
	 * @return la lista que contiene la informacion de las canciones favoritas
	 */
	List<Favorita> getFavoritas(Long idOyente);
	
	/**
	 * agrega una cancion de favoritas al oyente asociado al idOyente
	 * 
	 * @param idOyente id del oyente que agregara la cancion a favoritos
	 * @param idCancion id de la cancion que sera guardada en la lista de favoritas
	 */
	Boolean agregarAFavorita (Long idOyente, Long idCancion); 
	
	
	/**
	 * elimina una cancion de la lista de favoritas
	 * 
	 * @param id es el id de la cancion que sera eliminada
	 */
	Boolean eliminarDeFavoritas(Long idOyente, Long id);
	
	/**
	 * busca una cancion 
	 * 
	 * 
	 * @param idFavorita id de la cancion que se encuentra en la lista de favoritas
	 * @return la cancion favorita que esta asociada al idFavorita
	 */
	Favorita verFavorita(Long idOyente,Long idFavorita);
	
	
}
