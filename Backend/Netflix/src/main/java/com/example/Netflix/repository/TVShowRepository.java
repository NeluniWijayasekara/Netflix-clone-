package com.example.Netflix.repository;


import com.example.Netflix.model.TVShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TVShowRepository extends JpaRepository<TVShow, Long> {
    // Custom queries if needed
}

