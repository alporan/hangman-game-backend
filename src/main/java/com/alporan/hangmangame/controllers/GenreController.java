package com.alporan.hangmangame.controllers;

import com.alporan.hangmangame.apiTmdb.model.Genre;
import com.alporan.hangmangame.apiTmdb.services.GenreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class GenreController {
	
	private GenreService genreService;
	
	public GenreController(GenreService genreService) {
		this.genreService = genreService;
	}
	
	@GetMapping("/genre")
	public List< Genre > findAll(){
		return genreService.getGenres();
	}
	
	@GetMapping("/genre/{id}")
	public Genre findGenreById(@PathVariable(value = "id") int id) {
		
		List<Genre> genres = genreService.getGenres();
		
		for (Genre genre : genres) {
			if (id == genre.getId()) {
				return genre;
			}
		}
		return null;
	}
}
