package com.alporan.hangmangame.controllers;

import com.alporan.hangmangame.apiTmdb.model.Genre;
import com.alporan.hangmangame.apiTmdb.services.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GenreController {
	
	private GenreService genreService;
	
	public GenreController(GenreService genreService){
		this.genreService = genreService;
	}
	
	@GetMapping("/genres")
	public List< Genre > findAll(){
		return genreService.getGenres();
	}
	
	@GetMapping("/genre")
	public Genre findGenre(@RequestParam(value = "id", required = false) Integer id,
						  @RequestParam(value = "name", required = false) String name) {
		
		List<Genre> genres = genreService.getGenres();
		
		if (id == null && name == null) {
			return null;
		} else if (id == null) {
			for (Genre genre : genres) {
				if (name.equals(genre.getName())) {
					return genre;
				}
			}
			return null;
		} else if (name == null) {
			for (Genre genre : genres) {
				if (id.equals(genre.getId())) {
					return genre;
				}
			}
			return null;
		} else{
			for (Genre genre : genres) {
				if (id.equals(genre.getId()) && name.equals(genre.getName())) {
					return genre;
				}
			}
		}
		return null;
	}
}
