package com.springboot.app.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.usuarios.dao.PersonaDao;
import com.springboot.app.usuarios.models.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private PersonaDao personaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Persona> findAll() {
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	public Persona findById(Long id) {
		return personaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Persona save(Persona persona) {
		return personaDao.save(persona);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		personaDao.deleteById(id);
	}
}
