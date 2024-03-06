package com.project.movieAPI.controller;

import com.project.movieAPI.model.Movie;
import com.project.movieAPI.model.Review;
import com.project.movieAPI.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
//    @GetMapping("/")
//    public String apiRoot() {
//        return "Hello Viewers";
//    }
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(
                movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("{imdbId}")
    public ResponseEntity<Movie> getMovie(@PathVariable String imdbId){
        Movie movie= movieService.singleMovie(imdbId);
        if(movie!=null){
            ResponseEntity<Movie> movieResponseEntity = new ResponseEntity<Movie>(movie, HttpStatus.OK);
            return movieResponseEntity;
        }
        else
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{imdbId}/reviews")
    public ResponseEntity<List<Review>> getMovieReview(@PathVariable String imdbId){
        return new ResponseEntity<List<Review>>(movieService.getMovieReview(imdbId),HttpStatus.OK);
    }


}
