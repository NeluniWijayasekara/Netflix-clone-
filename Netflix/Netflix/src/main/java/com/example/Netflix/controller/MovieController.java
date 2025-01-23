package com.example.Netflix.controller;

import com.example.Netflix.model.Movie;
import com.example.Netflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/Movie")
@CrossOrigin(origins = "*")
public class MovieController {
    @Autowired
    private MovieService MovieService;
    @PostMapping
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie Movie){
        return new
                ResponseEntity<Movie>(MovieService.saveMovie(Movie),
                HttpStatus.CREATED);
    }
    //GetAll Rest Api
    @GetMapping
    public List<Movie> getAllMovie(){
        return MovieService.getAllMovie();
    }

    @GetMapping("{id}")
// localhost:8080/api/Movie/1
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") long
                                                          MovieID){
        return new
                ResponseEntity<Movie>(MovieService.getMovieById(MovieID),HttpStatus.OK);
    }
    //Update Rest Api@PutMapping("{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") long id, @RequestBody Movie Movie){
        return new
                ResponseEntity<Movie>(MovieService.updateMovie(Movie,id),HttpStatus.OK);
    }
    //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") long id){
//delete Movie from db
        MovieService.deleteMovie(id);
        return new ResponseEntity<String>("Movie deleted Successfully.",HttpStatus.OK);
    }
}

