package com.alporan.hangmangame.apiTmdb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ProductionCountry implements Serializable {
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("logo_path")
	private String logoPath;
	
	@JsonProperty("origin_country")
	private String originCountry;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLogoPath() {
		return logoPath;
	}
	
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	
	public String getOriginCountry() {
		return originCountry;
	}
	
	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}
	
	@Override
	public String toString() {
		return "ProductionCountry{" +
				"name='" + name + '\'' +
				", id=" + id +
				", logoPath='" + logoPath + '\'' +
				", originCountry='" + originCountry + '\'' +
				'}';
	}
}
