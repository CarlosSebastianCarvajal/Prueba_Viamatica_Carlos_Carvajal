package com.springboot.app.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.usuarios.dao.SessionesDao;
import com.springboot.app.usuarios.models.Sessiones;

@Service
public class SessionesServiceImpl implements ISessionesService{

	@Autowired
	private SessionesDao sessionesDao;
	
	@Override
	public List<Sessiones> findAll() {
		return (List<Sessiones>) sessionesDao.findAll();
	}

	@Override
	public Sessiones findById(Long id) {
		return sessionesDao.findById(id).orElse(null);
	}

	@Override
	public Sessiones save(Sessiones sessiones) {
		return sessionesDao.save(sessiones);
	}

	@Override
	public void deleteById(Long id) {
		sessionesDao.deleteById(id);
		
	}

}
