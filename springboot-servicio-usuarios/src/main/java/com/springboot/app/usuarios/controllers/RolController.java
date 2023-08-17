package com.springboot.app.usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.usuarios.models.Rol;
import com.springboot.app.usuarios.service.IRolService;

@RestController
public class RolController {
	
	@Autowired
	private IRolService iRolService;
	
	
	@PostMapping("/listarRol")
	public List<Rol> listar(){
		return iRolService.findAll();
	}
	
	@PostMapping("/verRol/{id}")
	public Rol detalle(@PathVariable Long id) {
		return iRolService.findById(id);
	}
	
	@PostMapping("/crearRol")
	@ResponseStatus(HttpStatus.CREATED)
	public Rol crear(@RequestBody Rol rol) {
		return iRolService.save(rol);
		
	}
	
	@PostMapping("/editarRol")
	@ResponseStatus(HttpStatus.CREATED)
	public Rol editar(@RequestBody Rol rol) {
        return iRolService.save(rol);
	}
	
	@PostMapping("/eliminarRol/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		iRolService.deleteById(id);
	}
}
