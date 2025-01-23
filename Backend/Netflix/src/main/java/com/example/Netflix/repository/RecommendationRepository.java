package com.example.Netflix.repository;

import com.example.Netflix.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    // Custom queries if needed
}

