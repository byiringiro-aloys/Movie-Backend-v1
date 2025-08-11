package dev.aloys.Movies.controller;

import dev.aloys.Movies.model.Reviews;
import dev.aloys.Movies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/reviews")
public class ReviewsController {
    @Autowired
    private ReviewService reviewService;
    public ResponseEntity<List<Reviews>> getAllReviews(){
        return new ResponseEntity<>(reviewService.getAllReviews(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reviews> createReview(@RequestBody Map<String,String> payload){
        return new ResponseEntity<>(reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId")), HttpStatus.CREATED);
    }


}
