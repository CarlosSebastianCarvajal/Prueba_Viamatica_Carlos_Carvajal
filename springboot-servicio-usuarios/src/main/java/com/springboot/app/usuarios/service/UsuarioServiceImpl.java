package com.springboot.app.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.usuarios.dao.UsuarioDao;
import com.springboot.app.usuarios.models.IniciarSesion;
import com.springboot.app.usuarios.models.Persona;
import com.springboot.app.usuarios.models.Usuario;

import com.github.cliftonlabs.json_simple.JsonObject;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private UsuarioDao usuarioDao;
	
	
	@Autowired
	private IPersonaService iPersonaService;
	
	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	public JsonObject save(Usuario usuario, int ident) {
		Usuario usuarioRes = null;
		JsonObject json = new JsonObject();
		
		if(ident == 1) {
			Persona persona = iPersonaService.save(usuario.getPersona());
			usuario.setPersona(persona);
			usuario.setIdpersona(persona.getIdpersona());
			usuario.setMail(generarCorreo(persona));
			usuarioRes = usuarioDao.save(usuario);
		}else if(ident == 2){
			Usuario usuarioDb = findById(usuario.getIdusuario());
				
				//segmento para persona   
				Persona personaDb = iPersonaService.findById(usuarioDb.getPersona().getIdpersona());
				personaDb.setNombres(usuario.getPersona().getNombres());
		        personaDb.setApellidos(usuario.getPersona().getApellidos());
		        personaDb.setIdentificacion(usuario.getPersona().getIdentificacion());
		        personaDb.setFechanacimiento(usuario.getPersona().getFechanacimiento());
		        iPersonaService.save(personaDb);
		        
	        usuarioDb.setUsername(usuario.getUsername());
	        usuarioDb.setContrasenia(usuario.getContrasenia());
	        usuarioDb.setSessionactive(usuario.getSessionactive());
	        usuarioDb.setStatus(usuario.getStatus());
	        usuarioRes = usuarioDao.save(usuarioDb);
		}
		json.put("info", usuarioRes);
		return json;
	}

	@Override
	public void deleteById(Long id) {
		usuarioDao.deleteById(id);
	}

	@Override
	public JsonObject iniciarSesion(IniciarSesion iniciarSesion) {
		JsonObject json = new JsonObject();
		json.put("action", 1);
		
		Usuario usuarioDb = usuarioDao.iniciarSesion(iniciarSesion.getUsername());
		if(usuarioDb != null) {
			if(usuarioDb.getContrasenia().equals(iniciarSesion.getContrasenia())) {
				usuarioDb.setContrasenia("No Disponible");
				json.put("access", 1);
				json.put("message", "Acceso Correcto");
				json.put("info", usuarioDb);
			}else {
				json.put("access", 0);
				json.put("message", "La contraseña ingresada es incorrecta, intente nuevamente");
				json.put("info", "void");
			}
		}else {
			json.put("access", 0);
			json.put("message", "El nombre de usuario es incorrecto o no se encuentra registrado en el sistema!!");
			json.put("info", "void");
		}
		return json;
	}
	
	
	//OTROS MÉTODOS

	// generar correo
		private String generarCorreo(Persona persona) {
			String apellidos = persona.getApellidos();
			int idx = apellidos.indexOf(" ");
			String correo_p1 = String.valueOf(persona.getNombres().charAt(0)) + apellidos.substring(0, idx) + String.valueOf(apellidos.charAt(idx+1));
			correo_p1 = correo_p1.toLowerCase();
			String correo_res = correo_p1;
			System.out.println(correo_p1);
			for(int i = 1; comprobarCorreo(correo_p1) >= 1 ; i++) {
				
				correo_p1 = correo_res + String.valueOf(i);
			}
			return correo_p1 + "@mail.com";
		}
		
		@Override
		public int comprobarCorreo(String cadena) {
			return usuarioDao.comprobarCorreo(cadena);
		}
	
}
