package com.example.Netflix.service.impl;
import com.example.Netflix.model.Movie;
import com.example.Netflix.repository.MovieRepository;
import com.example.Netflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository MovieRepository;
    //save Movie in database
    @Override
    public Movie saveMovie(Movie Movie){
        return MovieRepository.save(Movie);
    }

    @Override
    public List<Movie> getAllMovie() {
        return MovieRepository.findAll();
    }
    //get Movie using id
    @Override
    public Movie getMovieById(long id) {
        Optional<Movie> Movie = MovieRepository.findById(id);
        if(Movie.isPresent()){
            return Movie.get();
        }else {
            throw new RuntimeException();
        }
    }
    //update Movie
    @Override
    public Movie updateMovie(Movie Movie, long id) {
        Movie existingMovie =
                MovieRepository.findById(id).orElseThrow(
                        ()-> new RuntimeException()
                );
        existingMovie.setTitle(Movie.getTitle());
        existingMovie.setDescription(Movie.getDescription());
        existingMovie.setReleaseDate(Movie.getReleaseDate());
        existingMovie.setRating(Movie.getRating());
// save
        MovieRepository.save(existingMovie);
        return existingMovie;
    }
    @Override
    public void deleteMovie(long id) {
//check
        MovieRepository.findById(id).orElseThrow(()-> new RuntimeException());
//delete
        MovieRepository.deleteById(id);
    }
}