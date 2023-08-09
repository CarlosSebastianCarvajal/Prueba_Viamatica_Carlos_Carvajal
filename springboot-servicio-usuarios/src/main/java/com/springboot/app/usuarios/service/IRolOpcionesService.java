package com.springboot.app.usuarios.service;

import java.util.List;

import com.springboot.app.usuarios.models.RolOpciones;

public interface IRolOpcionesService {
public List<RolOpciones> findAll();
	
	public RolOpciones findById(Long id);
	
	public RolOpciones save(RolOpciones rolOpciones);
	
	public void deleteById(Long id);
}
