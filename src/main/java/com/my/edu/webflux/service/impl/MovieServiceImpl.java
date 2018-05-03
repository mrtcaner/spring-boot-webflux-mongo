package com.my.edu.webflux.service.impl;

import java.time.Duration;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.edu.webflux.entity.Movie;
import com.my.edu.webflux.event.MovieEvent;
import com.my.edu.webflux.repo.MovieRepository;
import com.my.edu.webflux.service.IMovieService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieServiceImpl implements IMovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Mono<Movie> findById(String id) {
		return movieRepository.findById(id);
	}

	@Override
	public Flux<MovieEvent> events(String id) {
		return Flux.<MovieEvent>generate(movieEventSynchronousSink ->
		{movieEventSynchronousSink.next(new MovieEvent(id,new Date()));
			System.out.println("Generating...");}).delayElements(Duration.ofSeconds(1));
	}

	@Override
	public Flux<Movie> findAllMovies() {
		return movieRepository.findAll();
	}
}
