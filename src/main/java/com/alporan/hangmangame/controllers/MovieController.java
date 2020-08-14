package com.alporan.hangmangame.controllers;

import com.alporan.hangmangame.apiTmdb.model.Movie;
import com.alporan.hangmangame.apiTmdb.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class MovieController {
	
	private MovieService movieService;
	
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping("/movie")
	public Movie findRandomMovie(@RequestParam(value="genre") Optional<Integer> genre,
									   @RequestParam(value="year") Optional<Integer> year) {
		
		Date today = new Date();
		Calendar calender = Calendar.getInstance();
		calender.setTime(today);
		int currentYear = calender.get(Calendar.YEAR);
		
		Random random = new Random();
		int randomMovieIndex = random.nextInt(9);
		int randomYear = random.nextInt(currentYear - 1959) + 1960;
		int randomMonth = random.nextInt(8) + 1;
		int randomDay = random.nextInt(28) + 1;
		
		String startDate;
		String endDate;
		
		if (year.isPresent()) {
			int tempYear;
			if ( year.get() + 9  < currentYear) {
				tempYear = random.nextInt(10) + year.get();
			} else{
				int yearDifference = currentYear - year.get();
				tempYear = random.nextInt(yearDifference + 1) + year.get();
			}
			startDate = tempYear + "-" + String.format("%02d", randomMonth) + "-" + String.format("%02d", randomDay);
			endDate = tempYear + "-" + String.format("%02d", randomMonth + 4) + "-" + String.format("%02d", randomDay);
		} else {
			startDate = randomYear + "-" + String.format("%02d", randomMonth) + "-" + String.format("%02d", randomDay);
			endDate = randomYear + "-" + String.format("%02d", randomMonth + 4) + "-" + String.format("%02d", randomDay);
		}
		
		if (genre.isPresent()) {
			return movieService.getDiscovery(genre.get(), startDate, endDate).get(randomMovieIndex);
		} else {
			return  movieService.getDiscovery(startDate, endDate).get(randomMovieIndex);
		}
	}
	
	@GetMapping("/movie/{id}")
	public Movie findMovieById(@PathVariable(value = "id") int id) {
		
		return movieService.getMovieById(id);
	}
}
