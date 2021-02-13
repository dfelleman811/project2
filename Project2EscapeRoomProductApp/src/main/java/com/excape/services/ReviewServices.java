package com.excape.services;

import java.util.List;

import com.excape.beans.Review;

public interface ReviewServices {
	
	public Review getReview(int reviewId);
	
	public List<Review> getReviewsByItem(int itemId);
	
	public List<Review> getReviewsByRating(int userRating);
	
	public List<Review> getReviewsByDifficulty(int userDiffRating);
	
	public Review addReview(Review r);
	
	public Review updateReview(Review rChange);
	
	public boolean deleteReview(int reviewId);

}
