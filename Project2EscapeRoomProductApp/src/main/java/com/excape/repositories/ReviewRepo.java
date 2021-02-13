package com.excape.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.excape.beans.Review;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Integer> {

	public List<Review> findByUserRating(int userRating);
	public List<Review> findByUserDifficulty(int userDiffRating);
}
