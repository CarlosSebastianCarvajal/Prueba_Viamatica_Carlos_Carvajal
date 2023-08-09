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

import com.springboot.app.usuarios.models.RolRolOpciones;
import com.springboot.app.usuarios.service.IRolRolOpcionesService;

@RestController
public class RolRolOpcionesController {
	
	@Autowired
	private IRolRolOpcionesService iRolRolOpcionesService;
	
	
	@GetMapping("/listarRol-RolOpciones")
	public List<RolRolOpciones> listar(){
		return iRolRolOpcionesService.findAll();
	}
	
	@GetMapping("/verRol-RolOpciones/{id}")
	public RolRolOpciones detalle(@PathVariable Long id) {
		return iRolRolOpcionesService.findById(id);
	}
	
	@PostMapping("/crearRol-RolOpciones")
	@ResponseStatus(HttpStatus.CREATED)
	public RolRolOpciones crear(@RequestBody RolRolOpciones rolRolOpciones) {
		return iRolRolOpcionesService.save(rolRolOpciones);
		
	}
	
	@PutMapping("/editarRol-RolOpciones/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public RolRolOpciones editar(@RequestBody RolRolOpciones rolRolOpciones, @PathVariable Long id) {
		RolRolOpciones rolrolDb = iRolRolOpcionesService.findById(id);
		
		rolrolDb.setIdrol(rolRolOpciones.getIdrol());
		rolrolDb.setIdopcion(rolRolOpciones.getIdopcion());
		
        return iRolRolOpcionesService.save(rolrolDb);
	}
	
	@DeleteMapping("/eliminarRol-RolOpciones/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		iRolRolOpcionesService.deleteById(id);
	}
}
