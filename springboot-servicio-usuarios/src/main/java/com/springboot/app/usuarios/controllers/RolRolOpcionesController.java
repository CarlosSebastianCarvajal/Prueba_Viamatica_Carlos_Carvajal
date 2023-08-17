package com.springboot.app.usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.usuarios.models.RolRolOpciones;
import com.springboot.app.usuarios.service.IRolRolOpcionesService;

@RestController
public class RolRolOpcionesController {
	
	@Autowired
	private IRolRolOpcionesService iRolRolOpcionesService;
	
	
	@PostMapping("/listarRol-RolOpciones")
	public List<RolRolOpciones> listar(){
		return iRolRolOpcionesService.findAll();
	}
	
	@PostMapping("/verRol-RolOpciones/{id}")
	public RolRolOpciones detalle(@PathVariable Long id) {
		return iRolRolOpcionesService.findById(id);
	}
	
	@PostMapping("/crearRol-RolOpciones")
	@ResponseStatus(HttpStatus.CREATED)
	public RolRolOpciones crear(@RequestBody RolRolOpciones rolRolOpciones) {
		return iRolRolOpcionesService.save(rolRolOpciones);
		
	}
	
	@PostMapping("/editarRol-RolOpciones")
	@ResponseStatus(HttpStatus.CREATED)
	public RolRolOpciones editar(@RequestBody RolRolOpciones rolRolOpciones) {
        return iRolRolOpcionesService.save(rolRolOpciones);
	}
	
	@PostMapping("/eliminarRol-RolOpciones/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		iRolRolOpcionesService.deleteById(id);
	}
}
