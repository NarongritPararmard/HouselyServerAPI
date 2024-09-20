package com.housely.Serevice;

import com.housely.Model.Review.Review;
import com.housely.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    public Review findById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}
