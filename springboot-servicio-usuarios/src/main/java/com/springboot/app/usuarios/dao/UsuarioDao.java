package com.springboot.app.usuarios.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.usuarios.models.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{
	
}
