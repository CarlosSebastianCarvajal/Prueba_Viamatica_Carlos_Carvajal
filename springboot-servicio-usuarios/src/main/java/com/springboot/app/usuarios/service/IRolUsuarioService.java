package com.springboot.app.usuarios.service;

import java.util.List;

import com.springboot.app.usuarios.models.RolUsuario;

public interface IRolUsuarioService {
	
	public List<RolUsuario> findAll();
	
	public RolUsuario findById(Long id);
	
	public RolUsuario save(RolUsuario rolUsuario);
	
	public void deleteById(Long id);
}
