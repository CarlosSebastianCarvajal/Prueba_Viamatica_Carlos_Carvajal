package com.springboot.app.usuarios.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="sessiones")
public class Sessiones {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idsession;
	
	@Temporal(TemporalType.DATE)
	private Date fechaingreso;
	
	@Temporal(TemporalType.DATE)
	private Date fechacierre;
	
	private Long idusuario;

	public Long getIdsession() {
		return idsession;
	}

	public void setIdsession(Long idsession) {
		this.idsession = idsession;
	}

	public Date getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public Date getFechacierre() {
		return fechacierre;
	}

	public void setFechacierre(Date fechacierre) {
		this.fechacierre = fechacierre;
	}

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}
	
	
}
