package com.springboot.app.usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.usuarios.models.RolUsuario;
import com.springboot.app.usuarios.service.IRolUsuarioService;

@RestController
public class RolUsuarioController {
	
	@Autowired
	private IRolUsuarioService iRolUsuarioService;
	
	
	@PostMapping("/listarRolUsuario")
	public List<RolUsuario> listar(){
		return iRolUsuarioService.findAll();
	}
	
	@PostMapping("/verRolUsuario/{id}")
	public RolUsuario detalle(@PathVariable Long id) {
		return iRolUsuarioService.findById(id);
	}
	
	@PostMapping("/crearRolUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public RolUsuario crear(@RequestBody RolUsuario rolUsuario) {
		return iRolUsuarioService.save(rolUsuario);
		
	}
	
	@PostMapping("/editarRolUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public RolUsuario editar(@RequestBody RolUsuario rolUsuario) {
        return iRolUsuarioService.save(rolUsuario);
	}
	
	@PostMapping("/eliminarRolUsuario/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		iRolUsuarioService.deleteById(id);
	}
	
	
}
