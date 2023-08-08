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

import com.springboot.app.usuarios.models.Persona;
import com.springboot.app.usuarios.models.Usuario;
import com.springboot.app.usuarios.service.IPersonaService;
import com.springboot.app.usuarios.service.IUsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private IUsuarioService iUsuarioService;
	
	@Autowired
	private IPersonaService iPersonaService;
	
	@GetMapping("/listarUsuario")
	public List<Usuario> listar(){
		return iUsuarioService.findAll();
	}
	
	@GetMapping("/verUsuario/{id}")
	public Usuario detalle(@PathVariable Long id) {
		return iUsuarioService.findById(id);
	}
	
	@PostMapping("/crearUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario crear(@RequestBody Usuario usuario) {
		
		Persona persona = iPersonaService.save(usuario.getPersona());
		usuario.setPersona(persona);
		usuario.setIdpersona(persona.getIdpersona());
		usuario.setMail(generarCorreo(persona));
		return iUsuarioService.save(usuario);
		
	}
	
	@PutMapping("/editarUsuario/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario editar(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario usuarioDb = iUsuarioService.findById(id);
		
		//usuarioDb.setIdpersona(usuario.getIdpersona());
        usuarioDb.setUsername(usuario.getUsername());
        usuarioDb.setContrasenia(usuario.getContrasenia());
        usuarioDb.setMail(usuario.getMail());
        usuarioDb.setSessionactive(usuario.getSessionactive());
        usuarioDb.setStatus(usuario.getStatus());
        
        return iUsuarioService.save(usuarioDb);
	}
	
	@DeleteMapping("/eliminarUsuario/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		iUsuarioService.deleteById(id);
	}
	
	// Método utilizado para generar el correo segun lo descrito en el documento de indicciones de la prueba  
	public String generarCorreo(Persona persona) {
		String nombres = persona.getNombres();
		String apellidos = persona.getApellidos();
		
		String correo_p1 = String.valueOf(nombres.charAt(0));
		int idx = apellidos.indexOf(" ");
		correo_p1 = correo_p1 + apellidos.substring(0, idx) + String.valueOf(apellidos.charAt(idx+1)) + "@mail.com";
		
		return correo_p1.toLowerCase();
	}
}
