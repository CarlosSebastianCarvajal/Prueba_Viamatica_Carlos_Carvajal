package com.springboot.app.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.usuarios.dao.RolOpcionesDao;
import com.springboot.app.usuarios.models.RolOpciones;

@Service
public class RolOpcionesServiceImpl implements IRolOpcionesService{

	@Autowired
	private RolOpcionesDao rolOpcionesDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<RolOpciones> findAll() {
		return (List<RolOpciones>) rolOpcionesDao.findAll();
	}

	@Override
	public RolOpciones findById(Long id) {
		return rolOpcionesDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public RolOpciones save(RolOpciones rolOpciones) {
		return rolOpcionesDao.save(rolOpciones);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		rolOpcionesDao.deleteById(id);
		
	}

}
