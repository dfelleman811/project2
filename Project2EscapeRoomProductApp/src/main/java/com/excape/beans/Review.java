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
	
	private int user_rating;
	
	private int user_difficulty_rating;
	
	private String user_review;
	
	private int company_rating;
	
	private int company_difficulty_rating;
	
	private String company_review;

	
	public Review() {
		super();
	}


	public Review(int item_id, int user_id, int user_rating, int user_difficulty_rating, String user_review, int company_rating,
			int company_difficulty_rating, String company_review) {
		super();
		this.item_id = item_id;
		this.user_id = user_id;
		this.user_rating = user_rating;
		this.user_difficulty_rating = user_difficulty_rating;
		this.user_review = user_review;
		this.company_rating = company_rating;
		this.company_difficulty_rating = company_difficulty_rating;
		this.company_review = company_review;
	}


	public Review(int review_id, int item_id, int user_id, int user_rating, int user_difficulty_rating, String user_review,
			int company_rating, int company_difficulty_rating, String company_review) {
		super();
		this.review_id = review_id;
		this.item_id = item_id;
		this.user_id = user_id;
		this.user_rating = user_rating;
		this.user_difficulty_rating = user_difficulty_rating;
		this.user_review = user_review;
		this.company_rating = company_rating;
		this.company_difficulty_rating = company_difficulty_rating;
		this.company_review = company_review;
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


	public int getUser_rating() {
		return user_rating;
	}


	public void setUser_rating(int user_rating) {
		this.user_rating = user_rating;
	}


	public int getUser_difficulty_rating() {
		return user_difficulty_rating;
	}


	public void setUser_difficulty_rating(int user_difficulty_rating) {
		this.user_difficulty_rating = user_difficulty_rating;
	}


	public String getUser_review() {
		return user_review;
	}


	public void setUser_review(String user_review) {
		this.user_review = user_review;
	}


	public int getCompany_rating() {
		return company_rating;
	}


	public void setCompany_rating(int company_rating) {
		this.company_rating = company_rating;
	}


	public int getCompany_difficulty_rating() {
		return company_difficulty_rating;
	}


	public void setCompany_difficulty_rating(int company_difficulty_rating) {
		this.company_difficulty_rating = company_difficulty_rating;
	}


	public String getCompany_review() {
		return company_review;
	}


	public void setCompany_review(String company_review) {
		this.company_review = company_review;
	}


	@Override
	public String toString() {
		return "Review [review_id=" + review_id + ", item_id=" + item_id + ",user_id=" + user_id + ", user_rating=" + user_rating
				+ ", user_difficulty_rating=" + user_difficulty_rating + ", user_review=" + user_review
				+ ", company_rating=" + company_rating + ", company_difficulty_rating=" + company_difficulty_rating
				+ ", company_review=" + company_review + "]";
	}
	
	
	
	
	
	

}
