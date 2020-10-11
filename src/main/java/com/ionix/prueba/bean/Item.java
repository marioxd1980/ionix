package com.ionix.prueba.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4655010621646295563L;

	private List<ItemDetail> items = new ArrayList<>();
	private Integer registerCount;

	public List<ItemDetail> getItems() {
		return items;
	}

	public void setItems(List<ItemDetail> items) {
		this.items = items;
	}

	public Integer getRegisterCount() {
		return registerCount;
	}

	public void setRegisterCount(Integer registerCount) {
		this.registerCount = registerCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}

}