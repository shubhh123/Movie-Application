package dev.spring.movie.controller;

import dev.spring.movie.model.Movie;
import dev.spring.movie.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

//    @GetMapping(path = "/check/status")
//    public ResponseEntity<String> statusCheck() {
//        return new ResponseEntity<String>("Server is up and running", HttpStatus.OK);
//    }

    //@GetMapping(path = "/retrieve/movies")
    @GetMapping()
    public ResponseEntity<List<Movie>> retrieveMovies() {
        List<Movie> listOfMovies = movieService.getAllMovies();
        return new ResponseEntity<List<Movie>>(listOfMovies, HttpStatus.OK);
    }

//    @GetMapping(path = "/get/movie/with/title/{title}")
    @GetMapping(path = "title/{title}")
    public ResponseEntity<List<Movie>> getMovieWithTitle(@PathVariable String title){
        List<Movie> movieList = movieService.getMovieWithTitle(title);
        return new ResponseEntity<List<Movie>>(movieList, HttpStatus.OK);
    }

    //@GetMapping(path = "/get/movie/with/id/{id}")
    @GetMapping(path = "id/{id}")
    public ResponseEntity<Optional<Movie>> getMovieWithId(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieWithId(id), HttpStatus.OK);
    }

    //@GetMapping(path = "/get/movie/with/imdbid/{imdbId}")
    @GetMapping(path = "/imdbId/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieWithId(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieWithImdbId(imdbId), HttpStatus.OK);
    }
}
