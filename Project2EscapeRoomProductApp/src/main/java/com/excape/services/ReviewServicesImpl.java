package com.excape.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.excape.beans.Review;

@Service
public class ReviewServicesImpl implements ReviewServices {

	@Override
	public Review getReview(int reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> getReviewsByItem(int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> getReviewsByRating(int userRating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> getReviewsByDifficulty(int userDiffRating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review addReview(Review r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review updateReview(Review rChange) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteReview(int reviewId) {
		// TODO Auto-generated method stub
		return false;
	}

}
