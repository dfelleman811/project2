package com.excape.services;

import java.util.List;

import com.excape.beans.Review;

public interface ReviewServices {
	
	public Review getReview(int reviewId);
	
	public List<Review> getReviewsByItem(Integer itemId);
	
	public List<Review> getReviewsByRating(Integer userRating);
	
	public List<Review> getReviewsByDifficulty(Integer userDiffRating);
	
	public Review addReview(Review r);
	
	public Review updateReview(Review rChange);
	
	public boolean deleteReview(int reviewId);

}
