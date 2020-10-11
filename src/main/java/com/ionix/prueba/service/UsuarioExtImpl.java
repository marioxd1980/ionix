package com.ionix.prueba.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ionix.prueba.bean.Item;
import com.ionix.prueba.bean.UsuarioExtBean;
import com.ionix.prueba.util.Encripta;

/**
 * Clase correspondiente al ejercicio 1B y 1C
 * @author Mario 
 */
@Service
public class UsuarioExtImpl implements UsuarioExt{

	@Autowired
	private RestTemplate clienteRest;
	
	private static final String RUT = "1-9";
	private static final String KEY = "ionix123456";
	
	/**
	 * Metodo que se conecta a una Api externa y trae sus datos
	 * @return usuarioExtBean
	 * @author Mario 
	 */
	@Override
	public UsuarioExtBean getUsuariosExt() {
		String rutEncriptado = Encripta.getRutEncriptado(RUT, KEY);
		String url = "https://sandbox.ionix.cl/test-tecnico/search?rut=" + rutEncriptado;
		
		UsuarioExtBean usuarioExtBean = new UsuarioExtBean();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		Long tiempoInicio = System.currentTimeMillis();
		ResponseEntity<UsuarioExtBean> responseEntity = clienteRest.exchange(url, HttpMethod.GET, entity, UsuarioExtBean.class);
		Long tiempoFinal =  System.currentTimeMillis();
		Long tiempoTotal = tiempoFinal - tiempoInicio;
		
		setBeanFinal(tiempoTotal, responseEntity, usuarioExtBean);
		
		return usuarioExtBean;
	}
	

	/**
	 * Metodo que setea el bean final que se devolvera a la vista
	 * @param tiempoTotal
	 * @param responseEntity
	 * @param usuarioExtBean
	 * @author Mario 
	 */
	private void setBeanFinal(Long tiempoTotal, ResponseEntity<UsuarioExtBean> responseEntity, UsuarioExtBean usuarioExtBean) {
		usuarioExtBean.setElapsedTime(tiempoTotal);
		usuarioExtBean.setDescription(responseEntity.getBody().getDescription());
		usuarioExtBean.setResponseCode(responseEntity.getBody().getResponseCode());
		usuarioExtBean.setResult(new Item());
		usuarioExtBean.getResult().setRegisterCount(responseEntity.getBody().getResult().getItems().size());	
	}
	
}
