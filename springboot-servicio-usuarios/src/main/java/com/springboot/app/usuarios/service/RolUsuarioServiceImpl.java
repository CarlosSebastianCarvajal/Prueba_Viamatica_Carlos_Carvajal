package com.springboot.app.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.usuarios.dao.RolUsuarioDao;
import com.springboot.app.usuarios.models.RolUsuario;

@Service
public class RolUsuarioServiceImpl implements IRolUsuarioService{

	@Autowired
	private RolUsuarioDao rolUsuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<RolUsuario> findAll() {
		return (List<RolUsuario>) rolUsuarioDao.findAll();
	}

	@Override
	public RolUsuario findById(Long id) {
		return rolUsuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public RolUsuario save(RolUsuario rolUsuario) {
		return rolUsuarioDao.save(rolUsuario);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		rolUsuarioDao.deleteById(id);
		
	}

}
