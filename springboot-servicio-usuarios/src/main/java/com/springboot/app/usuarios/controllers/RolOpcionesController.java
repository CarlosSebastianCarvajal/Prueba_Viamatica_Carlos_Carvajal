package com.springboot.app.usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.usuarios.models.RolOpciones;
import com.springboot.app.usuarios.service.IRolOpcionesService;

@RestController
public class RolOpcionesController {
	
	@Autowired
	private IRolOpcionesService iRolOpcionesService;
	
	
	@PostMapping("/listarRolOpciones")
	public List<RolOpciones> listar(){
		return iRolOpcionesService.findAll();
	}
	
	@PostMapping("/verRolOpciones/{id}")
	public RolOpciones detalle(@PathVariable Long id) {
		return iRolOpcionesService.findById(id);
	}
	
	@PostMapping("/crearRolOpciones")
	@ResponseStatus(HttpStatus.CREATED)
	public RolOpciones crear(@RequestBody RolOpciones rolOpciones) {
		return iRolOpcionesService.save(rolOpciones);
		
	}
	
	@PostMapping("/editarRolOpciones")
	@ResponseStatus(HttpStatus.CREATED)
	public RolOpciones editar(@RequestBody RolOpciones rolOpciones) {
        return iRolOpcionesService.save(rolOpciones);
	}
	
	@PostMapping("/eliminarRolOpciones/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		iRolOpcionesService.deleteById(id);
	}
}
