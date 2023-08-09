package com.springboot.app.usuarios.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.usuarios.models.Rol;

public interface RolDao extends CrudRepository<Rol, Long>{

}
