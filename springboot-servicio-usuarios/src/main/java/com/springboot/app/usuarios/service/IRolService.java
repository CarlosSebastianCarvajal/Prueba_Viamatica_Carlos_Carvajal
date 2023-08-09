package com.springboot.app.usuarios.service;

import java.util.List;

import com.springboot.app.usuarios.models.Rol;

public interface IRolService {
	
	public List<Rol> findAll();
	
	public Rol findById(Long id);
	
	public Rol save(Rol rol);
	
	public void deleteById(Long id);
}
