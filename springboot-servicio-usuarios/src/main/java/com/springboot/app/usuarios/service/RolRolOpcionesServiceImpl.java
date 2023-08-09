package com.springboot.app.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.usuarios.dao.RolRolOpcionesDao;
import com.springboot.app.usuarios.models.RolRolOpciones;

@Service
public class RolRolOpcionesServiceImpl implements IRolRolOpcionesService{

	@Autowired
	private RolRolOpcionesDao rolRolOpcionesDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<RolRolOpciones> findAll() {
		return (List<RolRolOpciones>) rolRolOpcionesDao.findAll();
	}

	@Override
	public RolRolOpciones findById(Long id) {
		return rolRolOpcionesDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public RolRolOpciones save(RolRolOpciones rolRolOpciones) {
		return rolRolOpcionesDao.save(rolRolOpciones);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		rolRolOpcionesDao.deleteById(id);
		
	}

}
