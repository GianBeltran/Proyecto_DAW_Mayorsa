package com.pe.cibertec.mayorsa.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pe.cibertec.mayorsa.modelo.bd.Usuario;
import com.pe.cibertec.mayorsa.repository.UsuarioRepository;



@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private BCryptPasswordEncoder 
		bCryptPasswordEncoder = 
			new BCryptPasswordEncoder();
	
	public Usuario buscarUsuarioPorNomusuario
		(String nomUsuario) {
		return usuarioRepository
				.findByNomusuario(nomUsuario);
	}
	
	public Usuario guardarUsuario(Usuario usuario) {
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		usuario.setActivo(true);
		return usuarioRepository.save(usuario);
	}
}
