package com.ionix.prueba.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import com.loopj.android.http.Base64;


public class Encripta {

	/**
	 * Metodo que encripta el rut
	 * @param rut
	 * @param key
	 * @return encryptedRut
	 * @author Mario 
	 */
	public static String getRutEncriptado(String rut, String key) {
		
		String encryptedRut = new String();
		
		try {
			DESKeySpec keySpec = new DESKeySpec(key.getBytes("UTF8"));
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			
			SecretKey secretKey=keyFactory.generateSecret(keySpec);
			
			byte[] cleartext = rut.getBytes("UTF8");
			Cipher cipher = Cipher.getInstance("DES");
			
			cipher.init(Cipher.ENCRYPT_MODE,secretKey);
			
			encryptedRut = Base64.encodeToString(cipher.doFinal(cleartext), Base64.DEFAULT);
			
			//Esta fue la parte mas dificil del programa, el \n
			encryptedRut = encryptedRut.replace("\n", "");

		}catch(Exception e) {
			e.printStackTrace();
		}
		return encryptedRut;

	}

}
