package com.springboot.app.usuarios.service;

import java.util.List;

import com.springboot.app.usuarios.models.Sessiones;

public interface ISessionesService {
	public List<Sessiones> findAll();
	
	public Sessiones findById(Long id);
	
	public Sessiones save(Sessiones sessiones);
	
	public void deleteById(Long id);
}
