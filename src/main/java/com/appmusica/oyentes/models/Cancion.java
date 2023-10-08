package com.appmusica.oyentes.models;

import java.sql.Time;
import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * entidad que mapea a una tabla llamada canciones en la base de datos.
 * 
 * @Author Mateo Rodriguez
 *
 */
@Entity
@Table(name = "canciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cancion {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "genero")
	private String genero;
	
	// Campo para la hora
    @Temporal(TemporalType.TIME)
    @Column(name="duracion")
    private Time duracion;

	@Column(name = "fechaPublicacion")
	private Timestamp estreno;
}
