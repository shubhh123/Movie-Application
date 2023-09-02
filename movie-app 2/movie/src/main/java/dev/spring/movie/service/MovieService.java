package dev.spring.movie.service;


import dev.spring.movie.model.Movie;
import dev.spring.movie.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getMovieWithTitle(String title) {
        List<Movie> movieDescription = movieRepository.findByTitle(title);
        return movieDescription;
    }

    public Optional<Movie> getMovieWithId(ObjectId id) {
        return movieRepository.findById(id);
    }

    public Optional<Movie> getMovieWithImdbId(String imdbId) {
        return movieRepository.findByImdbId(imdbId);
    }
}
