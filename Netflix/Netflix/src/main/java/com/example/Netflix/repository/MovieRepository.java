package com.example.Netflix.repository;

import com.example.Netflix.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Custom queries if needed
}
