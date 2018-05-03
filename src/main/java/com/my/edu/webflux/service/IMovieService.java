package com.my.edu.webflux.service;

import com.my.edu.webflux.entity.Movie;
import com.my.edu.webflux.event.MovieEvent;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMovieService {

	Mono<Movie> findById(String id);

	Flux<MovieEvent> events(String id);

	Flux<Movie> findAllMovies();

}
