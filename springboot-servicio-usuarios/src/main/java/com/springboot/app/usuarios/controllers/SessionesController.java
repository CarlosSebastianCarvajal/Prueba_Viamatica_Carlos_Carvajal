package com.springboot.app.usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.usuarios.models.Sessiones;
import com.springboot.app.usuarios.service.ISessionesService;

@RestController
public class SessionesController {
	
	@Autowired
	private ISessionesService iSessionesService;
	
	@PostMapping("/listarSession")
	public List<Sessiones> listar(){
		return iSessionesService.findAll();
	}
	
	@PostMapping("/verSession/{id}")
	public Sessiones detalle(@PathVariable Long id) {
		return iSessionesService.findById(id);
	}
	
	@PostMapping("/crearSession")
	@ResponseStatus(HttpStatus.CREATED)
	public Sessiones crear(@RequestBody Sessiones sessiones) {
		return iSessionesService.save(sessiones);
		
	}
	
	@PostMapping("/editarSession")
	@ResponseStatus(HttpStatus.CREATED)
	public Sessiones editar(@RequestBody Sessiones sessiones) {
        return iSessionesService.save(sessiones);
	}
	
	@PostMapping("/eliminarSession/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		iSessionesService.deleteById(id);
	}
}
