package com.my.edu.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.my.edu.webflux.entity.Movie;
import com.my.edu.webflux.event.MovieEvent;
import com.my.edu.webflux.service.IMovieService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

@RestController
public class MovieController {

	@Autowired
	IMovieService movieService;

	@GetMapping(value = "movies/{id}")
	public Mono<Movie> getById(@PathVariable String id){
		return movieService.findById(id);
	}

	@GetMapping(value ="movies/{id}/event", produces = TEXT_EVENT_STREAM_VALUE)
	public Flux<MovieEvent> getEvent(@PathVariable String id){
		return movieService.events(id );
	}

	@GetMapping(value ="movies/")
	public Flux<Movie> getAllMovies(){
		return movieService.findAllMovies();
	}
}
