package com.springboot.app.usuarios.service;

import java.util.List;

import com.springboot.app.usuarios.models.RolRolOpciones;

public interface IRolRolOpcionesService {
public List<RolRolOpciones> findAll();
	
	public RolRolOpciones findById(Long id);
	
	public RolRolOpciones save(RolRolOpciones rolRolOpciones);
	
	public void deleteById(Long id);
}
