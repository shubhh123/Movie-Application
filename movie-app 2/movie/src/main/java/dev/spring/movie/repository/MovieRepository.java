package dev.spring.movie.repository;

import dev.spring.movie.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    public List<Movie> findByTitle(String title);

    public Optional<Movie> findByImdbId(String imdbId);
}
