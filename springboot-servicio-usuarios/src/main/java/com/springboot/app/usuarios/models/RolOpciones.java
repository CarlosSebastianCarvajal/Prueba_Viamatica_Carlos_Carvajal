package com.springboot.app.usuarios.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rolopciones")
public class RolOpciones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idopcion;
	
	private String nombreopcion;

	public Long getIdopcion() {
		return idopcion;
	}

	public void setIdopcion(Long idopcion) {
		this.idopcion = idopcion;
	}

	public String getNombreopcion() {
		return nombreopcion;
	}

	public void setNombreopcion(String nombreopcion) {
		this.nombreopcion = nombreopcion;
	}

}
