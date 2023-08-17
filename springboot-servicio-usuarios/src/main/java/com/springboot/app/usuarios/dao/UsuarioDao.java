package com.springboot.app.usuarios.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.app.usuarios.models.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{ 
	
    @Query("select v from Usuario v where  v.username = ?1")
    Usuario iniciarSesion(String username);
    
    @Query(value="select count(mail) from usuario where mail like %?1%", nativeQuery = true)
    int comprobarCorreo(String cadena);
    
}
