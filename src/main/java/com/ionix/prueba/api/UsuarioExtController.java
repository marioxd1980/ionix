package com.ionix.prueba.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ionix.prueba.bean.UsuarioExtBean;
import com.ionix.prueba.service.UsuarioExt;

/**
 * Clase correspondiente al ejercicio 1B
 * @author Mario 
 */
@RestController
public class UsuarioExtController {
	
	@Autowired
	private UsuarioExt usuarioExt;
	
	/**
	 * Metodo que traera los datos de una consulta a una API externa
	 * @author Mario 
	 *
	 */
	@PostMapping("/consultar")
	public UsuarioExtBean consultar(){
		return usuarioExt.getUsuariosExt();
	}

}
