package dev.aloys.Movies.service;

import dev.aloys.Movies.model.Movies;
import dev.aloys.Movies.repository.MoviesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MoviesRepository moviesRepository;
    public MovieService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public List<Movies> allMovies(){
        return moviesRepository.findAll();
    }

    public Movies getMovieById(String id){
        return moviesRepository.findMovieByImdbId(id).orElse(null);
    }
}
