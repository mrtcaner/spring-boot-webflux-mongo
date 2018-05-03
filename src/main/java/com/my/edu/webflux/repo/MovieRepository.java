package com.my.edu.webflux.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.my.edu.webflux.entity.Movie;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {

}
