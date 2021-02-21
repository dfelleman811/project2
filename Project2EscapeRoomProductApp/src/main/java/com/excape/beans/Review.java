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
	
	@Column(name="item_id")
	private Integer itemId;
	
	private Integer user_id;
	
	private Integer userRating;
	
	private Integer userDifficultyRating;
	
	private String userReview;
	
	private Integer companyRating;
	
	private Integer companyDifficultyRating;
	
	private String companyReview;

	
	public Review() {
		super();
	}


	public Review(Integer item_id, Integer user_id, Integer userRating, Integer userDifficultyRating, String userReview, Integer companyRating,
			Integer companyDifficultyRating, String companyReview) {
		super();
		this.itemId = item_id;
		this.user_id = user_id;
		this.userRating = userRating;
		this.userDifficultyRating = userDifficultyRating;
		this.userReview = userReview;
		this.companyRating = companyRating;
		this.companyDifficultyRating = companyDifficultyRating;
		this.companyReview = companyReview;
	}


	public Review(int review_id, Integer item_id, Integer user_id, Integer userRating, Integer userDifficultyRating, String userReview,
			Integer companyRating, Integer companyDifficultyRating, String companyReview) {
		super();
		this.review_id = review_id;
		this.itemId = item_id;
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


	public Integer getItem_id() {
		return itemId;
	}
	
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public void setItem_id(Integer item_id) {
		this.itemId = item_id;
	}


	public Integer getUserRating() {
		return userRating;
	}


	public void setUserRating(Integer userRating) {
		this.userRating = userRating;
	}


	public Integer getUserDifficultyRating() {
		return userDifficultyRating;
	}


	public void setUserDifficultyRating(Integer userDifficultyRating) {
		this.userDifficultyRating = userDifficultyRating;
	}


	public String getUserReview() {
		return userReview;
	}


	public void setUserReview(String userReview) {
		this.userReview = userReview;
	}


	public Integer getCompanyRating() {
		return companyRating;
	}


	public void setCompanyRating(Integer companyRating) {
		this.companyRating = companyRating;
	}


	public Integer getCompanyDifficultyRating() {
		return companyDifficultyRating;
	}


	public void setCompanDIfficultyRating(Integer companyDifficultyRating) {
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
		return "Review [review_id=" + review_id + ", item_id=" + itemId + ",user_id=" + user_id + ", userRating=" + userRating
				+ ", userDifficultyRating=" + userDifficultyRating + ", userReview=" + userReview
				+ ", companyRating=" + companyRating + ", companyDifficultyRating=" + companyDifficultyRating
				+ ", companyReview=" + companyReview + "]";
	}
	
	
	
	
	
	

}
