package com.ionix.prueba.service;

import java.util.List;

import com.ionix.prueba.models.entity.Usuario;

public interface UsuarioService {

	public Usuario crear(Usuario usuario);
	
	public List<Usuario> listadoUsuarios();
	
	public Usuario buscarPorMail(String email);
	
}
