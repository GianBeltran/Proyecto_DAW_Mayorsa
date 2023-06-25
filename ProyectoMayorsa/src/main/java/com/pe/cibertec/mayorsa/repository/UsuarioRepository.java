package com.pe.cibertec.mayorsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.cibertec.mayorsa.modelo.bd.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Usuario findByEmail(String email);
	Usuario findByNomusuario(String username);

}
