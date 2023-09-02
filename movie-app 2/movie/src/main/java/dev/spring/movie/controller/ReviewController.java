package dev.spring.movie.controller;

import dev.spring.movie.model.Review;
import dev.spring.movie.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> postReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>(reviewService.postReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }

}
