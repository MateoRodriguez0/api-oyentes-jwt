package com.appmusica.oyentes.services.implementations;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.appmusica.oyentes.models.Favorita;
import com.appmusica.oyentes.repositories.CancionRepository;
import com.appmusica.oyentes.repositories.FavoritaRepository;
import com.appmusica.oyentes.repositories.OyenteRepository;
import com.appmusica.oyentes.services.OyenteServices;

/**
 * esta clase implementa la interfaz OyenteServices y contiene los metodos para crear la logica de negocio 
 * de los usuarios oyentes de la aplicacion. utiliza los repositorios para realizar las operaciones en la base de datos.
 *
 * @Author Mateo Rodriguez
 *
 */
@Service
@Primary
public class OyenteServicesImpl implements OyenteServices {

	
	@Override
	public List<Favorita> getFavoritas(Long idOyente) {
		
		
		return oyenteRepository.findById(idOyente)
				.get()
				.getFavoritas().stream()
				.collect(Collectors.toList());
	}

	@Override
	public Boolean agregarAFavorita(Long idOyente, Long idCancion) {
		
		Favorita favorita= new Favorita();
		
		Optional<Favorita> isfavorita=getFavoritas(idOyente)
				.stream()
				.filter(f-> f.getCancion().getId()==idCancion)
				.findFirst();
		
		 if(isfavorita.isPresent()) {
			 return false;
		 }
		
		 else if(cancionRepository.existsById(idCancion) && oyenteRepository.existsById(idOyente)) {
			favorita.setCancion(cancionRepository
					.findById(idCancion)
					.orElse(null));
			
			favorita.setOyente(oyenteRepository
					.findById(idOyente)
					.orElse(null));
			
			favorita.setAgregada(new Timestamp(System.currentTimeMillis()));
			favoritaRepository.save(favorita);
			
			return true;
		}
		
		return false;

	}

	@Override
	public Boolean eliminarDeFavoritas(Long idOyente, Long id) {
		
		Boolean eliminado=false;
		if(oyenteRepository.existsById(idOyente)==true && favoritaRepository.existsById(id)== true) {
			eliminado=true;
		}
		
		oyenteRepository.findById(idOyente)
		.ifPresent(o ->o.getFavoritas()
				.stream()
				.filter(f -> f.getId()== id)
				.findFirst()
				.ifPresent(favoritaRepository::delete));
				

		return eliminado;
	}

	@Override
	public Favorita verFavorita(Long idOyente,Long idFavorita) {
		
		
		return oyenteRepository.findById(idOyente)
				.get().getFavoritas()
				.stream()
				.filter(f-> f.getId()==idFavorita)
				.findFirst()
				.orElse(null);
	}

	
	@Autowired
	private FavoritaRepository favoritaRepository;

	@Autowired
	private  OyenteRepository oyenteRepository;
	
	@Autowired
	private CancionRepository cancionRepository;
}
