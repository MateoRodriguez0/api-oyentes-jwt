package com.appmusica.oyentes.models;


import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa a una cancion que ha sido agregada a favoritas por un oyente.
 * entidad que mapea a una tabla llamada canciones_favoritas_oyentes en la base de datos.
 * tiene una relacion ManyToOne con la entidad Cancion,tiene una relacion ManyToOne con la entidad Oyente.
 * 
 * @Author Mateo Rodriguez
 *
 */
@Entity
@Table(name = "canciones_favoritas_oyentes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Favorita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
	@JoinColumn(name = "idOyente")
	private Oyente oyente;
	
	
	@ManyToOne()
	@JoinColumn(name = "idCancion")
	private Cancion cancion;
	
	@Column(name="fechaAgregada")
	private Timestamp agregada;
	
	
}
