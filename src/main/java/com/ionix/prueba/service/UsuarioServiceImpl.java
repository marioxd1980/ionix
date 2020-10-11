package com.ionix.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ionix.prueba.models.dao.UsuarioDao;
import com.ionix.prueba.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public Usuario crear(Usuario usuario) {
		return usuarioDao.save(usuario);
	}
	
	@Override
	public List<Usuario> listadoUsuarios() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	public Usuario buscarPorMail(String email) {
		return usuarioDao.findByEmail(email);
	}



}
