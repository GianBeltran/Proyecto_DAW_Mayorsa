package com.pe.cibertec.mayorsa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pe.cibertec.mayorsa.modelo.bd.Usuario;



@Service
public class UsuarioDetalleService implements UserDetailsService {
	
	@Autowired
	private UsuarioService usuarioService;
	

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.buscarUsuarioPorNomusuario(username);
        return usuarioPorAutenticacion(usuario);
    }

    private UserDetails usuarioPorAutenticacion(Usuario usuario) {
        return new User(usuario.getNomusuario(), usuario.getPassword(), usuario.getActivo(), true, true, true,
                Collections.emptyList());
    }
}