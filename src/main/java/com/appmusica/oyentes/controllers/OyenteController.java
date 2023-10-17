package com.appmusica.oyentes.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.appmusica.oyentes.services.OyenteServices;


/**
 * Este es un controlador de peticiones http personalizado para manipular las canciones favoritas de los oyentes en la aplicacion.
 * 
 * @Author Mateo Rodriguez
 *
 */
@RestController
@RequestMapping(value = "/favoritas")
public class OyenteController {

	/**
	 * busca el listado de canciones favoritas de el usuario asociado a la variable del path {id}.
	 * utiliza el metodo oyenteServices.getFavoritas(id) de la clase de servicio para buscar el oyente en la base de datos,
	 * y devuelve la lista de favoritas del usuario.   
	 * 
	 * @param id es el id del usuario oyente.
	 * @return ResponseEntity con la lista de Favoritas en el body.
	 */
	@GetMapping(value = "/listar/{id}")
	public ResponseEntity<?> listFavoritas (@PathVariable(name = "id") Long id){
		
		
		return ResponseEntity.ok(oyenteServices.getFavoritas(id));
	}
	
	

	/**
	 * Corresponde a una peticion http delete que se encarga de eliminar una cancion de la lista de favoritas de un oyente
	 * 
	 * @param idOyente  es el id del usuario oyente.
	 * @param idFav es el id de la cancion que se encuentra en favoritas.
	 * @return ResponseEntity con el mensaje correspondiente al resultado de la operacion.
	 */
	@DeleteMapping(value = "/delete/{idoyente}/{idfavorita}")
	public ResponseEntity<String>  deleteFavorita(@PathVariable(name = "idoyente") Long idOyente ,@PathVariable(name = "idfavorita") Long idFav){
		
		
		if(oyenteServices.eliminarDeFavoritas(idOyente, idFav)==true) {	
			return ResponseEntity.ok("Se ha eliminado la cancion de favoritos");
		}
		
		return ResponseEntity.ok("No se pudo eliminar la cancion de favoritos");
		
		
	}
	
	
	/**
	 * Corresponde a una peticion http asociada al HttpMethod Post, 
	 * agrega una cancion a las favoritas de un oyente en la aplicacion.
	 * 
	 * @param idOyente es el id del usuario oyente.
	 * @param idCancion es el id de la usuario cancion.
	 * @return  ResponseEntity con un mensaje en el body que indica el resultado de la peticion.
	 */
	@PostMapping(value = "/save/{idoyente}/{idcancion}")
	public ResponseEntity<String>  addFavorita(@PathVariable(name = "idoyente")Long idOyente, @PathVariable(name = "idcancion")Long idCancion){
		
		if(oyenteServices.agregarAFavorita(idOyente, idCancion)) {
			return ResponseEntity.ok("Se ha agregado a favoritas");
		}
		
		return ResponseEntity.ok("No se pudo agregar la cancion a favoritos");
	}
	
	
	/**
	 * Corresponede a una peticion http asociada al HttpMethod Get, 
	 * se encarga de obtener una cancion que se encuentra en las favoritas del oyente.
	 * 
	 * @param idoyente es el id del usuario oyente.
	 * @param idFavorita es el id de la cancion favorita, este id no es el mismo de la cancion.
	 * @return ResponseEntity con la cancion favorita en el body.
	 */
	@GetMapping(value = "/search/{idoyente}/{idfavorita}")
	public ResponseEntity<?> getfavorita( @PathVariable(name = "idoyente")Long idoyente ,
			@PathVariable(name = "idfavorita") Long idFavorita){
		
		return ResponseEntity.ok(oyenteServices.verFavorita(idoyente, idFavorita));
	}
	
	
	@Autowired
	private OyenteServices oyenteServices;
	
	
}
