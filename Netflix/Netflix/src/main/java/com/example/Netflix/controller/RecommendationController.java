package com.example.Netflix.controller;

import com.example.Netflix.model.Recommendation;
import com.example.Netflix.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/Recommendation")
@CrossOrigin(origins = "*")
public class RecommendationController {
    @Autowired
    private RecommendationService RecommendationService;
    @PostMapping
    public ResponseEntity<Recommendation> saveRecommendation(@RequestBody Recommendation Recommendation){
        return new
                ResponseEntity<Recommendation>(RecommendationService.saveRecommendation(Recommendation),
                HttpStatus.CREATED);
    }
    //GetAll Rest Api
    @GetMapping
    public List<Recommendation> getAllRecommendation(){
        return RecommendationService.getAllRecommendation();
    }

    @GetMapping("{id}")
// localhost:8080/api/Recommendation/1
    public ResponseEntity<Recommendation> getRecommendationById(@PathVariable("id") long
                                                                            RecommendationID){
        return new
                ResponseEntity<Recommendation>(RecommendationService.getRecommendationById(RecommendationID),HttpStatus.OK);
    }
    //Update Rest Api@PutMapping("{id}")
    public ResponseEntity<Recommendation> updateRecommendation(@PathVariable("id") long id, @RequestBody Recommendation Recommendation){
        return new
                ResponseEntity<Recommendation>(RecommendationService.updateRecommendation(Recommendation,id),HttpStatus.OK);
    }
    //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRecommendation(@PathVariable("id") long id){
//delete Recommendation from db
        RecommendationService.deleteRecommendation(id);
        return new ResponseEntity<String>("Recommendation deleted Successfully.",HttpStatus.OK);
    }
}

