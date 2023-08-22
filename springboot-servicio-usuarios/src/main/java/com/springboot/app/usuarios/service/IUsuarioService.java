package com.springboot.app.usuarios.service;

import java.util.List;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.springboot.app.usuarios.models.IniciarSesion;
import com.springboot.app.usuarios.models.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findById(Long id);
	
	public JsonObject save(Usuario usuario);
	
	public JsonObject update(Usuario usuario);
	
	public void deleteById(Long id);
	
	
	public JsonObject iniciarSesion(IniciarSesion iniciarSesion);
	
	public int comprobarCorreo(String cadena);
	
	public int comprobarUsername(String cadena);
	
	public int contarIdentificacion(String cadena);
	
	public Boolean validarNumRepetidos(String cadena);
}
