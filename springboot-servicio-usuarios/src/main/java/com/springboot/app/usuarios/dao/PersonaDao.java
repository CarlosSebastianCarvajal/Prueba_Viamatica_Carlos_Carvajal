package com.springboot.app.usuarios.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.usuarios.models.Persona;

public interface PersonaDao extends CrudRepository<Persona, Long>	{

}
