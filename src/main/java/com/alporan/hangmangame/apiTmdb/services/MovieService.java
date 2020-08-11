package com.alporan.hangmangame.apiTmdb.services;

import com.alporan.hangmangame.apiTmdb.model.Movie;

import java.util.List;

public interface MovieService {

	List<Movie> getDiscovery(String startDate, String endDate);
	List<Movie> getDiscovery(int genreId, String startDate, String endDate);
	
	Movie getMovieById(long id);
}
