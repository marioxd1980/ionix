package com.ionix.prueba.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.ionix.prueba.models.entity.Usuario;

@Service
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

	public Usuario findByEmail(String email);
}
