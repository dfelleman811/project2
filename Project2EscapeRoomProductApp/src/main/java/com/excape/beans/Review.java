package com.excape.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {
	
	@Id
	@Column(name = "review_id", updatable = false)
	@GeneratedValue(generator = "reviews_review_id_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "reviews_review_id_seq", sequenceName = "reviews_review_id_seq", allocationSize = 1)
	private int review_id;
	
	private int item_id;
	
	private int user_id;
	
	private int userRating;
	
	private int userDifficultyRating;
	
	private String userReview;
	
	private int companyRating;
	
	private int companyDifficultyRating;
	
	private String companyReview;

	
	public Review() {
		super();
	}


	public Review(int item_id, int user_id, int userRating, int userDifficultyRating, String userReview, int companyRating,
			int companyDifficultyRating, String companyReview) {
		super();
		this.item_id = item_id;
		this.user_id = user_id;
		this.userRating = userRating;
		this.userDifficultyRating = userDifficultyRating;
		this.userReview = userReview;
		this.companyRating = companyRating;
		this.companyDifficultyRating = companyDifficultyRating;
		this.companyReview = companyReview;
	}


	public Review(int review_id, int item_id, int user_id, int userRating, int userDifficultyRating, String userReview,
			int companyRating, int companyDifficultyRating, String companyReview) {
		super();
		this.review_id = review_id;
		this.item_id = item_id;
		this.user_id = user_id;
		this.userRating = userRating;
		this.userDifficultyRating = userDifficultyRating;
		this.userReview = userReview;
		this.companyRating = companyRating;
		this.companyDifficultyRating = companyDifficultyRating;
		this.companyReview = companyReview;
	}


	public int getReview_id() {
		return review_id;
	}


	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}


	public int getItem_id() {
		return item_id;
	}
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}


	public int getUserRating() {
		return userRating;
	}


	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}


	public int getUserDifficultyRating() {
		return userDifficultyRating;
	}


	public void setUserDifficultyRating(int userDifficultyRating) {
		this.userDifficultyRating = userDifficultyRating;
	}


	public String getUserReview() {
		return userReview;
	}


	public void setUserReview(String userReview) {
		this.userReview = userReview;
	}


	public int getCompanyRating() {
		return companyRating;
	}


	public void setCompanyRating(int companyRating) {
		this.companyRating = companyRating;
	}


	public int getCompanyDifficultyRating() {
		return companyDifficultyRating;
	}


	public void setCompanDIfficultyRating(int companyDifficultyRating) {
		this.companyDifficultyRating = companyDifficultyRating;
	}

	public String getCompanyReview() {
		return companyReview;
	}


	public void setCompanyReview(String companyReview) {
		this.companyReview = companyReview;
	}


	@Override
	public String toString() {
		return "Review [review_id=" + review_id + ", item_id=" + item_id + ",user_id=" + user_id + ", userRating=" + userRating
				+ ", userDifficultyRating=" + userDifficultyRating + ", userReview=" + userReview
				+ ", companyRating=" + companyRating + ", companyDifficultyRating=" + companyDifficultyRating
				+ ", companyReview=" + companyReview + "]";
	}
	
	
	
	
	
	

}
