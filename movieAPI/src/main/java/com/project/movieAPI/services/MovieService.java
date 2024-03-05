package com.project.movieAPI.services;

import com.project.movieAPI.dao.MovieRepository;
import com.project.movieAPI.model.Movie;
import com.project.movieAPI.model.Review;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie singleMovie(String imdbId){
        return movieRepository.findByImdbId(imdbId);
    }

    public List<Review> getMovieReview(String imdbId){
        Movie movie=movieRepository.findByImdbId(imdbId);
        List<Review> reviews = movie.getReviewIds();
        return reviews;
    }

}
