package com.ionix.prueba.bean;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Detail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6849361108619720288L;
	private String email;
	private String phone_number;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Detail [email=");
		builder.append(email);
		builder.append(", phone_number=");
		builder.append(phone_number);
		builder.append("]");
		return builder.toString();
	}

}