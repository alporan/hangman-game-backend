package com.alporan.hangmangame.apiTmdb.services;

import com.alporan.hangmangame.apiTmdb.model.Genres;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.alporan.hangmangame.apiTmdb.model.Genre;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
	
	private RestTemplate restTemplate;
	
	private final String api_url;
	private final String api_key;
	private final String api_language;
	
	public GenreServiceImpl(RestTemplate restTemplate,
							@Value("${tmdb_genre_url}") String api_url,
							@Value("${tmdb_api_key}") String api_key,
							@Value("${tmdb_language}") String api_language) {
		this.restTemplate = restTemplate;
		this.api_url = api_url;
		this.api_key = api_key;
		this.api_language = api_language;
	}
	
	@Override
	public List<Genre> getGenres() {
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder
				.fromUriString(api_url)
				.queryParam("api_key", api_key)
				.queryParam("language", api_language);

		
		Genres genres = restTemplate.getForObject(uriBuilder.toUriString(), Genres.class);
		return genres.getGenres();
	}
}
