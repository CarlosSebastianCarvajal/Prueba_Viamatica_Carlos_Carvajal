package com.springboot.app.usuarios.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rolrolopciones")
public class RolRolOpciones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idrolrolopciones;
	
	private Long idopcion, idrol;

	public Long getIdrolrolopciones() {
		return idrolrolopciones;
	}

	public void setIdrolrolopciones(Long idrolrolopciones) {
		this.idrolrolopciones = idrolrolopciones;
	}

	public Long getIdopcion() {
		return idopcion;
	}

	public void setIdopcion(Long idopcion) {
		this.idopcion = idopcion;
	}

	public Long getIdrol() {
		return idrol;
	}

	public void setIdrol(Long idrol) {
		this.idrol = idrol;
	}

	
}
