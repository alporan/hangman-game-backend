package com.alporan.hangmangame.apiTmdb.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Discovery implements Serializable {
	
	@JsonProperty("page")
	int page;
	
	@JsonProperty("total_results")
	int totalResults;
	
	@JsonProperty("total_pages")
	int totalPages;
	
	@JsonProperty("results")
	List<Movie> results;
	
	public int getPage() {
		return page;
	}
	
	public int getTotalResults() {
		return totalResults;
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	
	public List<Movie> getResults() {
		return results;
	}
	
	@Override
	public String toString() {
		return "Discovery{" +
				"page=" + page +
				", totalResults=" + totalResults +
				", totalPages=" + totalPages +
				", results=" + results +
				'}';
	}
}
