package com.alporan.hangmangame.apiTmdb.services;

import com.alporan.hangmangame.apiTmdb.model.Movie;
import com.alporan.hangmangame.apiTmdb.model.Discovery;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
	
	private RestTemplate restTemplate;
	
	private final String api_discovery_url;
	private final String api_movie_url;
	private final String api_key;
	private final String api_language;
	private final String sortBy = "popularity.desc";
	private final boolean includeAdult = false;
	private final String originalLanguage = "en";
	
	public MovieServiceImpl(RestTemplate restTemplate,
							@Value("${tmdb_discovery_url}") String api_discovery_url,
							@Value("${tmdb_movie_url}") String api_movie_url,
							@Value("${tmdb_api_key}") String api_key,
							@Value("${tmdb_language}") String api_language) {
		this.restTemplate = restTemplate;
		this.api_discovery_url = api_discovery_url;
		this.api_movie_url = api_movie_url;
		this.api_key = api_key;
		this.api_language = api_language;
	}
	
	@Override
	public List<Movie> getDiscovery(String startDate, String endDate) {
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder
				.fromUriString(api_discovery_url)
				.queryParam("api_key", api_key)
				.queryParam("language", api_language)
				.queryParam("sort_by", sortBy)
				.queryParam("include_adult", includeAdult)
				.queryParam("with_original_language", originalLanguage)
				.queryParam("primary_release_date.gte", startDate)
				.queryParam("primary_release_date.lte", endDate);
		
		
		Discovery discovery = restTemplate.getForObject(uriBuilder.toUriString(), Discovery.class);
		return discovery.getResults();
	}
	
	@Override
	public List<Movie> getDiscovery(int genreId, String startDate, String endDate) {
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder
				.fromUriString(api_discovery_url)
				.queryParam("api_key", api_key)
				.queryParam("language", api_language)
				.queryParam("sort_by", sortBy)
				.queryParam("include_adult", includeAdult)
				.queryParam("with_original_language", originalLanguage)
				.queryParam("primary_release_date.gte", startDate)
				.queryParam("primary_release_date.lte", endDate)
				.queryParam("with_genres", genreId);
		
		
		Discovery discovery = restTemplate.getForObject(uriBuilder.toUriString(), Discovery.class);
		return discovery.getResults();
	}
	
	@Override
	public Movie  getMovieById(long id) {
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder
				.fromUriString(api_movie_url + "/" + id)
				.queryParam("api_key", api_key)
				.queryParam("language", api_language);
		
		return restTemplate.getForObject(uriBuilder.toUriString(), Movie.class);
	}
}
