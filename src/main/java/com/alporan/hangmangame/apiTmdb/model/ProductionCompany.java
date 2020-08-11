package com.alporan.hangmangame.apiTmdb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ProductionCompany implements Serializable {
	@JsonProperty("iso_3166_1")
	private String iso_3166_1;
	
	@JsonProperty("name")
	private String name;
	
	public String getIso_3166_1() {
		return iso_3166_1;
	}
	
	public void setIso_3166_1(String iso_3166_1) {
		this.iso_3166_1 = iso_3166_1;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ProductionCompany{" +
				"iso_3166_1='" + iso_3166_1 + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}