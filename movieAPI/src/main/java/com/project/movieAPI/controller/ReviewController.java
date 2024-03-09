package com.project.movieAPI.controller;

import com.project.movieAPI.model.Review;
import com.project.movieAPI.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/movies")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/{imdbId}/reviews")
    public ResponseEntity<Review> postNewReview(@PathVariable String imdbId, @RequestBody Map<String,String> payload){
        return new ResponseEntity<Review>(reviewService.createReview(imdbId, payload.get("cmnts")), HttpStatus.CREATED);
    }

}
