package com.springboot.app.usuarios.service;

import java.util.List;

import com.springboot.app.usuarios.models.Persona;

public interface IPersonaService {
	
	public List<Persona> findAll();
	
	public Persona findById(Long id);
	
	public Persona save(Persona persona);
	
	public void deleteById(Long id);
}
