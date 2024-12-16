package com.exercises.movies.repository;

import com.exercises.movies.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository <Movie,Long> {
    List<Movie> getMoviesByYearReleased(int year);
    List<Movie> getAllMoviesByOrderByYearReleased();
    List<Movie> findByIsSequelIsTrue();
}
