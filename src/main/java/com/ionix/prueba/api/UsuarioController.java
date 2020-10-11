package com.ionix.prueba.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ionix.prueba.models.entity.Usuario;
import com.ionix.prueba.service.UsuarioService;

/**
 * Clase correspondiente al ejercicio 1A
 * @author Mario 
 *
 */
@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	/**
	 * Metodo que se encarga de crear un nuevo usuario
	 * @param usuario
	 * @return Usuario
	 * @author Mario 
	 */
	@PostMapping("/crear")
	public Usuario crear(@RequestBody Usuario usuario) {
		return usuarioService.crear(usuario);
	}
	
	/**
	 * Metodo que se encarga de listar todos los usuarios
	 * @return List<Usuario>
	 * @author Mario 
	 *
	 */
	@GetMapping("/listar")
	public List<Usuario> listadoUsuarios() {
		return (List<Usuario>) usuarioService.listadoUsuarios();
	}
	
	/**
	 * Metodo que se encarga de buscar un usuario por el email
	 * @param email
	 * @return Usuario
	 * @author Mario 
	 */
	@GetMapping("/buscar-mail")
	public Usuario buscarPorMail(@RequestParam String email) {
		return usuarioService.buscarPorMail(email);
	}

}
