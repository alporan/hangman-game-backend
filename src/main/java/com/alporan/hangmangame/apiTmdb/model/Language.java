package com.alporan.hangmangame.apiTmdb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Language implements Serializable {
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("iso_639_1")
	private String ido_639_1;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIdo_639_1() {
		return ido_639_1;
	}
	
	public void setIdo_639_1(String ido_639_1) {
		this.ido_639_1 = ido_639_1;
	}
	
	@Override
	public String toString() {
		return "Language{" +
				"name='" + name + '\'' +
				", ido_639_1='" + ido_639_1 + '\'' +
				'}';
	}
}
