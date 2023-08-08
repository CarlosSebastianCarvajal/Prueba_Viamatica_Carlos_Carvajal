package com.springboot.app.usuarios.service;

import java.util.List;

import com.springboot.app.usuarios.models.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findById(Long id);
	
	public Usuario save(Usuario usuario);
	
	public void deleteById(Long id);
}
