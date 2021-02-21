package com.excape.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excape.beans.Review;
import com.excape.repositories.ReviewRepo;

@Service
public class ReviewServicesImpl implements ReviewServices {
	
	@Autowired
	private ReviewRepo rr;

	@Override
	public Review getReview(int reviewId) {
		return rr.findById(reviewId).get();
	}

	@Override
	public List<Review> getReviewsByItem(Integer itemId) {
		return (List<Review>) rr.findByItemId(itemId);
	}

	@Override
	public List<Review> getReviewsByRating(Integer userRating) {
		return rr.findByUserRating(userRating);
	}

	@Override
	public List<Review> getReviewsByDifficulty(Integer userDiffRating) {
		return rr.findByUserDifficultyRating(userDiffRating);
	}

	@Override
	public Review addReview(Review r) {
		return rr.save(r);
	}

	@Override
	public Review updateReview(Review rChange) {
		return rr.save(rChange);
	}

	@Override
	public boolean deleteReview(int reviewId) {
		try {
			rr.delete(rr.findById(reviewId).get());
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

}
