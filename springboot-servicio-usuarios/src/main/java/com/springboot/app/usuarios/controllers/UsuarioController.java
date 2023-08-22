package com.springboot.app.usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.springboot.app.usuarios.models.IniciarSesion;
import com.springboot.app.usuarios.models.Usuario;
import com.springboot.app.usuarios.service.IUsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private IUsuarioService iUsuarioService;
	
	
	@PostMapping("/listarUsuario")
	public List<Usuario> listar(){
		return iUsuarioService.findAll();
	}
	
	@PostMapping("/verUsuario/{id}")
	public Usuario detalle(@PathVariable Long id) {
		return iUsuarioService.findById(id);
	}
	
	@PostMapping("/crearUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public JsonObject crear(@RequestBody Usuario usuario) {
		return iUsuarioService.save(usuario);
	}
	
	@PostMapping("/editarUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public JsonObject editar(@RequestBody Usuario usuario) {
        return iUsuarioService.update(usuario);
	}
	
	@PostMapping("/eliminarUsuario/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		iUsuarioService.deleteById(id);
	}
	
	
	//Inicio de sesion
	@PostMapping("/iniciarSesion")
	public JsonObject iniciarSesion(@RequestBody IniciarSesion iniciarSesion) {
		return iUsuarioService.iniciarSesion(iniciarSesion);
	}
	
	
	
	// PARA COMPROBAR MÉTODOS EXTRAS
	@PostMapping("/contarIdentificacion")
	public int contarIdentificacion(@RequestBody JsonObject jsonObject) {
		return iUsuarioService.contarIdentificacion(jsonObject.get("identificacion").toString());
	}
	
	@PostMapping("/comprobarUsername")
	public int comporbarUsername(@RequestBody JsonObject jsonObject) {
		return iUsuarioService.comprobarUsername(jsonObject.get("username").toString());
	}
	
	@PostMapping("/validarNumRepetidos")
	public Boolean validarNumRep(@RequestBody JsonObject jsonObject) {
		return iUsuarioService.validarNumRepetidos(jsonObject.get("username").toString());
	}
	
}
