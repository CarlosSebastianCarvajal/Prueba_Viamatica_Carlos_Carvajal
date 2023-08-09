package com.springboot.app.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.usuarios.dao.RolDao;
import com.springboot.app.usuarios.models.Rol;

@Service
public class RolServiceImpl implements IRolService{

	@Autowired
	private RolDao rolDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Rol> findAll() {
		return (List<Rol>) rolDao.findAll();
	}

	@Override
	public Rol findById(Long id) {
		return rolDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Rol save(Rol rol) {
		return rolDao.save(rol);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		rolDao.deleteById(id);
		
	}

}
