package com.springboot.app.usuarios.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.usuarios.models.RolUsuario;

public interface RolUsuarioDao extends CrudRepository<RolUsuario, Long>{

}
