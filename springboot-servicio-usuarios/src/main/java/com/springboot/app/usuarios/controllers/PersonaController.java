package com.springboot.app.usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.springboot.app.usuarios.models.Persona;
import com.springboot.app.usuarios.service.IPersonaService;

@RestController
public class PersonaController {
	
	@Autowired
	private IPersonaService iPersonaService;
	
	@GetMapping("/listarPersona")
	public List<Persona> listar(){
		return iPersonaService.findAll();
	}
	
	@GetMapping("/verPersona/{id}")
	public Persona detalle(@PathVariable Long id) {
		return iPersonaService.findById(id);
	}
	
	@PostMapping("/crearPersona")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona crear(@RequestBody Persona persona) {
		return iPersonaService.save(persona);
		
	}
	
	@PutMapping("/editarPersona/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona editar(@RequestBody Persona persona, @PathVariable Long id) {
		Persona personaDb = iPersonaService.findById(id);
		
		personaDb.setNombres(persona.getNombres());
        personaDb.setApellidos(persona.getApellidos());
        personaDb.setIdentificacion(persona.getIdentificacion());
        personaDb.setFechanacimiento(persona.getFechanacimiento());
        
        return iPersonaService.save(personaDb);
	}
	
	@DeleteMapping("/eliminarPersona/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		iPersonaService.deleteById(id);
	}
}
