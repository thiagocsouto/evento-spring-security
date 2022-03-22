package com.evento.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.evento.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	
//	@Query("select b from Usuario b where b.login = :login and b.senha = :senha")
//	public Usuario findByLogin(String login, String senha); 
	public Usuario findByUsername(String username);  

}
