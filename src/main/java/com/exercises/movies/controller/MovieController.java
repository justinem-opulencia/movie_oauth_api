package com.exercises.movies.controller;

import com.exercises.movies.model.Genre;
import com.exercises.movies.model.Movie;
import com.exercises.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/")
    public String publicPath() {
        return "Hello, home!";
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMoviesByOrderByYearReleased();
    }

    @GetMapping("/movies/{year}")
    public  List<Movie> getAllMoviesByYear(@PathVariable("year") int year){
        return movieService.getMoviesByYear(year);
    }

    @GetMapping("/movies/{genre}/{issequel}")
    public List<Movie> getMoviesByGenreAndIsSequel(@PathVariable("genre") Genre genre, @PathVariable("issequel") boolean isSequel){
        return movieService.getMoviesByGenreAndIsSequel(genre,isSequel);
    }
}
