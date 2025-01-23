package com.example.Netflix.service;

import com.example.Netflix.model.Movie;
import com.example.Netflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public interface MovieService {
    Movie saveMovie(Movie Movie);
    List<Movie> getAllMovie();
    Movie getMovieById(long id);
    Movie updateMovie(Movie Movie,long id);
    void deleteMovie(long id);
}