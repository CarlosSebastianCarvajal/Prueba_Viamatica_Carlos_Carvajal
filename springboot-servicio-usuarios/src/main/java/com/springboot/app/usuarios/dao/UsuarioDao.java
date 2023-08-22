package com.springboot.app.usuarios.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.app.usuarios.models.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{ 
	
    @Query("select v from Usuario v where  v.username = ?1")
    Usuario iniciarSesion(String username);
    
  //@Query("select count(v.mail) from Usuario v where  v.mail like %?1%")
    @Query(value="select count(mail) from usuario where mail like %?1%", nativeQuery = true)    
    int comprobarCorreo(String cadena);
    
    /////////////@Query(value="select count(username) from usuario where username = ?1", nativeQuery = true)
    @Query("select count(u.username) from Usuario u  where u.username = ?1")
    int comprobarUsername(String cadena);
    
    //////////////////@Query(value="select count(p.identificacion)	from persona as p inner join usuario as u on p.idpersona = u.idpersona	where p.identificacion = ?1", nativeQuery = true)   
    @Query("select count(u.persona.identificacion) from Usuario u inner join u.persona  where u.persona.identificacion = ?1")
    int contarIdentificacion(String identificacion);
}
