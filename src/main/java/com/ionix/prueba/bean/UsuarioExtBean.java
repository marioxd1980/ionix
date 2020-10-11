package com.ionix.prueba.bean;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioExtBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3270133209513517006L;

	private Integer responseCode;
	private String description;
	private Long elapsedTime;
	private Item result;

	public UsuarioExtBean() {

	}

	public UsuarioExtBean(Integer responseCode, String description, Item result) {
		super();
		this.responseCode = responseCode;
		this.description = description;
		this.result = result;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(Long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public Item getResult() {
		return result;
	}

	public void setResult(Item result) {
		this.result = result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsuarioExtBean [responseCode=");
		builder.append(responseCode);
		builder.append(", description=");
		builder.append(description);
		builder.append(", result=");
		builder.append(result);
		builder.append("]");
		return builder.toString();
	}

}
