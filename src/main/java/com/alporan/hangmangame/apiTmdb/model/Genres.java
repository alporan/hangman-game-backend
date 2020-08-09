package com.alporan.hangmangame.apiTmdb.model;

import com.alporan.hangmangame.apiTmdb.model.Genre;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Genres implements Serializable {
	
	@JsonProperty("genres")
	List<Genre> genres;
	
	public List<Genre> getGenres() {
		return genres;
	}
	
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	
	@Override
	public String toString() {
		return "Genres{" +
				"genres=" + genres +
				'}';
	}
}