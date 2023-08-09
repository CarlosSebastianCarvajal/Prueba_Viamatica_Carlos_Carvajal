package com.springboot.app.usuarios.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="rolusuario")
public class RolUsuario  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idrolusuario;
	
	private Long idrol, idusuario;
	
	public Long getIdrolusuario() {
		return idrolusuario;
	}

	public void setIdrolusuario(Long idrolusuario) {
		this.idrolusuario = idrolusuario;
	}

	public Long getIdrol() {
		return idrol;
	}

	public void setIdrol(Long idrol) {
		this.idrol = idrol;
	}

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}
	
	
}
