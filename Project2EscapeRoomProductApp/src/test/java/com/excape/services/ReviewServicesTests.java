package com.excape.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.excape.beans.Review;
import com.excape.repositories.ReviewRepo;

@SpringBootTest(classes = com.excape.app.Project2EscapeRoomProductAppApplication.class)
class ReviewServicesTests {
	
	@MockBean
	ReviewRepo rr;
	
	@Autowired
	ReviewServices rs;

	@Test
	void getReviewById() {
		Review r = new Review(1, 1, 1, 5, 6, "user review", 5,
				5, "company review");
		
		Mockito.when(rr.findById(1)).thenReturn(Optional.of(r));
		
		Review r2 = rs.getReview(1);
		
		Assertions.assertEquals(r, r2);
	}
	
	@Test
	void getReviewsByItem() {
		List<Review> list = new ArrayList<Review>();
		list.add(new Review(1, 1, 1, 5, 6, "user review", 5,
				5, "company review"));
		list.add(new Review(1, 2, 2, 5, 6, "user review", 5,
				5, "company review"));
		
		Mockito.when(rr.findByItemId(1)).thenReturn(list);
		
		List<Review> list2 = rs.getReviewsByItem(1);
		
		Assertions.assertEquals(list, list2);
	}
	
	@Test
	void getReviewsByRating() {
		List<Review> list = new ArrayList<Review>();
		list.add(new Review(1, 1, 2, 5, 6, "user review", 5,
				5, "company review"));
		list.add(new Review(1, 2, 2, 5, 6, "user review", 5,
				5, "company review"));
		
		Mockito.when(rr.findByUserRating(5)).thenReturn(list);
		
		List<Review> list2 = rs.getReviewsByRating(5);
		
		Assertions.assertEquals(list, list2);
	}
	
	@Test
	void getReviewsByDifficulty() {
		List<Review> list = new ArrayList<Review>();
		list.add(new Review(1, 1, 2, 5, 6, "user review", 5,
				5, "company review"));
		list.add(new Review(2, 2, 2, 5, 6, "user review", 5,
				5, "company review"));
		
		Mockito.when(rr.findByUserDifficultyRating(6)).thenReturn(list);
		
		List<Review> list2 = rs.getReviewsByDifficulty(6);
		
		Assertions.assertEquals(list, list2);
	}
	
	@Test
	void addReview() {
		Review r = new Review(1, 1, 5, 6, "user review", 5,
				5, "company review");
		
		Mockito.when(rr.save(r)).thenReturn(new Review(1, r.getItem_id(), r.getUser_id(), r.getUserRating(), r.getUserDifficultyRating(), r.getUserReview(), r.getCompanyRating(),
				r.getCompanyDifficultyRating(), r.getCompanyReview()));
		
		r = rs.addReview(r);
		Assertions.assertEquals(1, r.getReview_id());
	}
	
	@Test
	void updateReview() {
		Review r = new Review(1, 1, 1, 5, 6, "user review", 5,
				5, "company review");
		
		Review change = new Review(1, 1, 6, 7, 4, "user review change", 3,
				5, "company review change");
		
		Mockito.when(rr.save(change)).thenReturn(r = change);
		
		rs.updateReview(change);
		
		Assertions.assertEquals(r, change);
	}
	
	@Test
	void deleteReview() {
		Review r = new Review(1, 1, 6, 7, 4, "user review change", 3,
				5, "company review change");
		Optional<Review> optional = Optional.of(r);
		
		Mockito.when(rr.findById(r.getReview_id())).thenReturn(optional);
		Mockito.doNothing().when(rr).delete(r);
		rs.deleteReview(1);
	}

}
