package com.example.Netflix.service;

import com.example.Netflix.model.Recommendation;
import com.example.Netflix.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public interface RecommendationService {
    Recommendation saveRecommendation(Recommendation Recommendation);
    List<Recommendation> getAllRecommendation();
    Recommendation getRecommendationById(long id);
    Recommendation updateRecommendation(Recommendation Recommendation,long id);
    void deleteRecommendation(long id);
}
