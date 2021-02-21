package com.excape.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excape.beans.Review;
import com.excape.services.ReviewServices;

@RestController
@CrossOrigin
public class ReviewController {
	
	@Autowired
	private ReviewServices rs;
	
	// hmmm - will Spring be able to differentiate between these methods that simply take an id? Does it know which id we're passing it?
	// or do we need to be explicit in another way - since technically it's just pulling the int from the path params...
	
	@GetMapping(value = "/reviews/{id}", produces = "application/json")
	public Review getReview(@PathVariable("id") int reviewId) {
		return rs.getReview(reviewId);
	}
	
	
	@GetMapping(value = "/reviewsByItem/{id}", produces = "application/json")
	public List<Review> getReviewsByItem(@PathVariable("id") Integer itemId) { 
		return rs.getReviewsByItem(itemId);
	}
	
	
	@GetMapping(value = "/reviewsByRating/{id}", produces = "application/json")
	public List<Review> getReviewsByRating(@PathVariable("id") Integer userRating) {
		return rs.getReviewsByRating(userRating);
	}
	
	
	@GetMapping(value = "/reviewsByDifficulty/{id}", produces = "application/json")
	public List<Review> getReviewsByDifficulty(@PathVariable("id") Integer userDiffRating) {
		return rs.getReviewsByRating(userDiffRating);
	}
	
	
	@PostMapping(value = "/reviews", consumes = "application/json", produces = "application/json")
	public Review addReview(@RequestBody Review r) {
		return rs.addReview(r);
	}
	
	
	@PutMapping(value = "/reviews/{id}", consumes = "application/json", produces = "application/json")
	public Review updateReview(@PathVariable("id") int id, @RequestBody Review rChange) {
		rChange.setReview_id(id);
		return rs.updateReview(rChange);
	}
	
	
	@DeleteMapping(value = "/reviews/{id}")
	public boolean deleteReview(@PathVariable("id") int reviewId) {
		return rs.deleteReview(reviewId);
	}
	
	
	
}
