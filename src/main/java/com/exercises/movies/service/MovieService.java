package com.exercises.movies.service;

import com.exercises.movies.model.Genre;
import com.exercises.movies.model.Movie;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    List<Movie> getMoviesByYear(int year);
    List<Movie> getAllMoviesByOrderByYearReleased();
    List<Movie> getMoviesByGenreAndIsSequel(Genre genre, boolean isSequel);

    @PreAuthorize("isAuthenticated()")
    String getSecurity();
//    List<Movie> getMoviesByGenre(Genre genre);
}
