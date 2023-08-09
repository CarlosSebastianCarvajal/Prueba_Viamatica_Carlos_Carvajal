package com.springboot.app.usuarios.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.usuarios.models.Sessiones;

public interface SessionesDao  extends CrudRepository<Sessiones, Long>{
	
}
