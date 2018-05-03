package com.my.edu.webflux.bootstrap;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.my.edu.webflux.entity.Movie;
import com.my.edu.webflux.repo.MovieRepository;

import reactor.core.publisher.Flux;

@Component
public class BootstrapCLR implements CommandLineRunner {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public void run(String... args) throws Exception {
		movieRepository.deleteAll().block();

		Flux.just("Movie1","Movie2","Movie3","Movie4","Movie5","Movie6")
				.map(m -> new Movie(m, UUID.randomUUID().toString()))
				.flatMap(movieRepository::save)
				.subscribe(null,null,()->
				movieRepository.findAll().subscribe(System.out::println)
				);
	}
}
