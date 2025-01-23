package com.example.Netflix.controller;

import com.example.Netflix.model.TVShow;
import com.example.Netflix.service.TVShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/TVShow")
@CrossOrigin(origins = "*")
public class TVShowController {
    @Autowired
    private TVShowService TVShowService;
    @PostMapping
    public ResponseEntity<TVShow> saveTVShow(@RequestBody TVShow TVShow){
        return new
                ResponseEntity<TVShow>(TVShowService.saveTVShow(TVShow),
                HttpStatus.CREATED);
    }
    //GetAll Rest Api
    @GetMapping
    public List<TVShow> getAllTVShow(){
        return TVShowService.getAllTVShow();
    }

    @GetMapping("{id}")
// localhost:8080/api/TVShow/1
    public ResponseEntity<TVShow> getTVShowById(@PathVariable("id") long
                                                            TVShowID){
        return new
                ResponseEntity<TVShow>(TVShowService.getTVShowById(TVShowID),HttpStatus.OK);
    }
    //Update Rest Api@PutMapping("{id}")
    public ResponseEntity<TVShow> updateTVShow(@PathVariable("id") long id, @RequestBody TVShow TVShow){
        return new
                ResponseEntity<TVShow>(TVShowService.updateTVShow(TVShow,id),HttpStatus.OK);
    }
    //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTVShow(@PathVariable("id") long id){
//delete TVShow from db
        TVShowService.deleteTVShow(id);
        return new ResponseEntity<String>("TVShow deleted Successfully.",HttpStatus.OK);
    }
}

