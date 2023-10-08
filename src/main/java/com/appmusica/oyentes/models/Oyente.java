package com.appmusica.oyentes.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * entidad que mapea a una tabla llamada oyentes en la base de datos.
 * Es un usuario que puede agregar canciones una lista de favoritas.
 * Tiene una relacion de OneToMany con la entidad Favorita.
 * 
 * @Author Mateo Rodriguez
 *
 */
@Entity
@Table(name = "oyentes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Oyente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "oyente",fetch = FetchType.EAGER)
	private List<Favorita>favoritas;
	
}
