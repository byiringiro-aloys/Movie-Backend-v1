package dev.aloys.Movies.service;

import com.mongodb.client.MongoDatabase;
import dev.aloys.Movies.model.Movies;
import dev.aloys.Movies.model.Reviews;
import dev.aloys.Movies.repository.ReviewRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;
    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository=reviewRepository;
    }

    @Autowired
    private MongoTemplate mongoTemplate;

    public Reviews createReview(String reviewBody, String imdbId){
        Reviews review = reviewRepository.insert(new Reviews(reviewBody));

        mongoTemplate.update(Movies.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
    }


    public List<Reviews> getAllReviews() {
        return reviewRepository.findAll();
    }
}
