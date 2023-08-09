package com.springboot.app.usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.usuarios.models.RolOpciones;
import com.springboot.app.usuarios.service.IRolOpcionesService;

@RestController
public class RolOpcionesController {
	
	@Autowired
	private IRolOpcionesService iRolOpcionesService;
	
	
	@GetMapping("/listarRolOpciones")
	public List<RolOpciones> listar(){
		return iRolOpcionesService.findAll();
	}
	
	@GetMapping("/verRolOpciones/{id}")
	public RolOpciones detalle(@PathVariable Long id) {
		return iRolOpcionesService.findById(id);
	}
	
	@PostMapping("/crearRolOpciones")
	@ResponseStatus(HttpStatus.CREATED)
	public RolOpciones crear(@RequestBody RolOpciones rolOpciones) {
		return iRolOpcionesService.save(rolOpciones);
		
	}
	
	@PutMapping("/editarRolOpciones/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public RolOpciones editar(@RequestBody RolOpciones rolOpciones, @PathVariable Long id) {
		RolOpciones rolDb = iRolOpcionesService.findById(id);
		
		rolDb.setNombreopcion(rolOpciones.getNombreopcion());
        
        return iRolOpcionesService.save(rolDb);
	}
	
	@DeleteMapping("/eliminarRolOpciones/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		iRolOpcionesService.deleteById(id);
	}
}
