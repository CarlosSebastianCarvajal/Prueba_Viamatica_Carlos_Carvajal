package com.springboot.app.usuarios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.usuarios.dao.UsuarioDao;
import com.springboot.app.usuarios.models.IniciarSesion;
import com.springboot.app.usuarios.models.Persona;
import com.springboot.app.usuarios.models.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.google.gson.Gson;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private UsuarioDao usuarioDao;
	
	
	@Autowired
	private IPersonaService iPersonaService;
	
	private final String NUMERO_USUARIO="select t from usuario t where t.nombreUsuario = :nUsuario";
	private final String JSON_TEST="";
	
	Gson gson = new Gson().newBuilder().disableHtmlEscaping().setPrettyPrinting().serializeNulls().create();
	
	@PersistenceContext
	EntityManager entityManager; 
	public ArrayList<Usuario> validarUsuario(String cadena){
		try {
			Query query =  entityManager.createQuery(cadena);
			query.setParameter(0, query);
			
			JsonObject jsonObject = gson.fromJson(JSON_TEST, JsonObject.class);
			String email = jsonObject.get("email").toString();
			
			ArrayList<Usuario> usuarios = (ArrayList<Usuario>) query.getResultList();
			for(Usuario usuario : usuarios) {
				if(usuario.getMail().equals(cadena)) {
					
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	public JsonObject save(Usuario usuario) {
		Usuario usuarioRes = null;
		JsonObject json = new JsonObject();
		
		
		json.put("action", 2);
		String msgUser = validarUser(usuario);
		if(msgUser.equals("ok")) {
			String msgPass = validarPass(usuario);
			if(msgPass.equals("ok")) {
				String msgIdent = validarIdentificacion(usuario);
				if(msgIdent.equals("ok")) {
					// Aqui se ejecuta el guardado
					/*
					Persona persona = iPersonaService.save(usuario.getPersona());
					usuario.setPersona(persona);
					usuario.setIdpersona(persona.getIdpersona());
					usuario.setMail(generarCorreo(persona));
					usuarioRes = usuarioDao.save(usuario);
					*/
					json.put("access", 1);
					json.put("message", "Datos Guardos Correctamente");
					json.put("info", "aquí irian los datos");
				}else {
					json.put("access", 0);
					json.put("message", msgIdent);
					json.put("info", "void");
				}
			}else {
				json.put("access", 0);
				json.put("message", msgPass);
				json.put("info", "void");
			}
		}else {
			json.put("access", 0);
			json.put("message", msgUser);
			json.put("info", "void");
		}
		
			
		return json;
	}
	
	@Override
	public JsonObject update(Usuario usuario) {
		Usuario usuarioRes = null;
		JsonObject json = new JsonObject();
		
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

	
	
	@Override
	public int comprobarCorreo(String cadena) {
		return usuarioDao.comprobarCorreo(cadena);
	}
	
	@Override
	public int comprobarUsername(String cadena) {
		return usuarioDao.comprobarUsername(cadena);
	}
	
	@Override
	public int contarIdentificacion(String identificacion) {
		return usuarioDao.contarIdentificacion(identificacion);
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
	
	private String validarUser(Usuario usuario) {
		String msjResponse = "void";
		if(usuario.getUsername().length() >= 8 && usuario.getUsername().length() <= 20) {
			if(contarMayusculas(usuario.getUsername()) >= 1) {
				if(contarNumeros(usuario.getUsername()) >= 1) {
					if(contarSignos(usuario.getUsername()) == 0) {
						if(comprobarUsername(usuario.getUsername()) == 0){
							msjResponse = "ok";
						}else {
							msjResponse = "El nombre de usuario ya está en uso, por favor ingresar un nombre de usuario distinto";
						}
					}else {
						msjResponse = "El nombre de usuario solo debe contener letras y numeros (evitar signos)";
					}
				}else {
					msjResponse = "El nombre de usuario debe contener al menos un número";
				}
			}else {
				msjResponse = "El nombre de usuario debe contener al menos una letra mayuscula";
			}
		}else {
			msjResponse = "El nombre de usuario debe contener entre 8 a 20 caracteres";
		}
		return msjResponse;
	}
	
	private String validarPass(Usuario usuario) {
		String msjResponse = "void";
		
		if(usuario.getUsername().length() >= 8) {
			if(contarMayusculas(usuario.getContrasenia()) >= 1) {
				if(contarSignos(usuario.getContrasenia()) >= 1) {
					if(contarEspacios(usuario.getContrasenia()) == 0) {
						msjResponse = "ok";
					}else {
						msjResponse = "La contraseña no debe contener espacios";
					}
				}else {
					msjResponse = "La contraseña debe contener al menos un signo";
				}
			}else {
				msjResponse = "La contraseña debe contener al menos una letra mayuscula";
			}
		}else {
			msjResponse = "La contraseña debe contener al menos 8 caracteres";
		}
		return msjResponse;
	}
	
	public String validarIdentificacion(Usuario usuario) {
		String msjResponse = "void";
		if(usuario.getPersona().getIdentificacion().length() == 10) {
			if(contarNumeros(usuario.getPersona().getIdentificacion()) == 10) {
				if(validarNumRepetidos(usuario.getPersona().getIdentificacion())) {
					msjResponse = "ok";
				}else {
					msjResponse = "La identificacion posee numeros repetidos";
				}
			}else {
				msjResponse = "La identificacion solo debe contener números";
			}
		}else {
			msjResponse = "La identificacion debe poseer una longitud de 10 caracteres";
		}
		return msjResponse;
	}
	
	 private int contarMayusculas(String cadena){
		 int total=0;
		 for(int i=0;i<cadena.length();i++){
			 if(cadena.charAt(i)>=65 && cadena.charAt(i)<=90){
				 total++;
			 }
		 }
		 return total;
	 }
	
	 private int contarNumeros(String cadena){
		 int total=0;
		 for(int i=0;i<cadena.length();i++){
			 if(cadena.charAt(i)>=48 && cadena.charAt(i)<=57){
				 total++;
			 }
		 }
		 return total;
	 }
	 
	 private int contarSignos(String cadena){
		 int total=0;
		 for(int i=0;i<cadena.length();i++){
			 if(!((cadena.charAt(i)>=48 && cadena.charAt(i)<=57) || (cadena.charAt(i)>=65 && cadena.charAt(i)<=90) || (cadena.charAt(i)>=97 && cadena.charAt(i)<=122))){
				 total++;
			 }
		 }
		 return total;
	 }
	 
	 private int contarEspacios(String cadena){
		 int total=0;
		 for(int i=0;i<cadena.length();i++){
			 if(cadena.charAt(i)==32){
				 total++;
			 }
		 }
		 return total;
	 }
	 
	 public Boolean validarNumRepetidos(String cadena) {
		 Boolean res = true;
		 for(int i=0;i < 7;i++){
			 char idx = cadena.charAt(i);
			 int cont = 0;
			 for(int j = i; j <= i + 3; j++) {
				 if(idx == cadena.charAt(j)) {
					 cont++;
				 }
			 }
			 if(cont >= 4) {
				 res = false;
			 }
		 }
		 return res;
	 }
		
}
