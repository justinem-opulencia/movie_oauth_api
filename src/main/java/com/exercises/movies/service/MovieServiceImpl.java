package com.exercises.movies.service;

import com.exercises.movies.model.Genre;
import com.exercises.movies.model.Movie;
import com.exercises.movies.repository.MovieRepository;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies(){
        List<Movie> results = new ArrayList<>();
        movieRepository.findAll().forEach(movie -> results.add(movie));
        return results;
    }
    public HashSet<String> getEnums(){
        HashSet<String> values = new HashSet<>();
        for (Genre genre: Genre.values()){
            values.add(genre.name());
        }
        return values;
    }

    @Override
    public List<Movie> getMoviesByYear(int year) {
        List<Movie> results = new ArrayList<>();
        movieRepository.findAll().forEach(movie -> {
            if(movie.getYearReleased() == year){
                results.add(movie);
            }
        });
        return results;
    }

    @Override
    public List<Movie> getAllMoviesByOrderByYearReleased() {
        List<Movie> results = getAllMovies();
        results.sort((o1,o2)->Integer.compare(o1.getYearReleased(),o2.getYearReleased()));
        results.sort(Comparator.comparing(Movie::getYearReleased));
        return results;
    }

    @Override
    public List<Movie> getMoviesByGenreAndIsSequel(Genre genre, boolean isSequel) {
        List<Movie> results = new ArrayList<>();
        if(!getEnums().contains(genre.name())){
            return null;
        } else {
            movieRepository.findAll().forEach(movie -> {
                if(movie.getGenre().contains(genre) && movie.isSequel() == isSequel){
                    results.add(movie);
                }
            });
            return results;
        }


    }

    @Override
    public String getSecurity() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "" + auth;
    }

//    @Override
//    public List<Movie> getMoviesByGenre(Genre genre) {
//        List<Movie> results = new ArrayList<>();
//        if(!getEnums().contains(genre.name())){
//            return null;
//        } else {
//            movieRepository.findAll().forEach(movie -> {
//                if(movie.getGenre().contains(genre)){
//                    results.add(movie);
//                }
//            });
//            return results;
//        }
//    }

}
