package com.excape.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.excape.beans.Review;
import com.excape.beans.Vendor;
import com.excape.services.ReviewServices;
import com.excape.services.VendorServices;
import com.google.gson.Gson;

@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@SpringBootTest(classes = com.excape.app.Project2EscapeRoomProductAppApplication.class)
class ReviewControllerTests {

	@Autowired
	private Gson gson;

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ReviewServices rs;

	@Autowired
	private JacksonTester<Review> jsonReview;

//---------------------------------------------------------------------------------------------------------------------

	@Test
	void testGetReview() throws Exception {
		// given
		given(rs.getReview(1))
			.willReturn(new Review(2, 1, 5, 10, null, 1, 1, null));

		// when
		MockHttpServletResponse response = mvc.perform(
			get("/reviews/1")
				.accept(MediaType.APPLICATION_JSON))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());
		assertEquals(response.getContentAsString(),
			jsonReview.write(new Review(2, 1, 5, 10, null, 1, 1, null)).getJson()
		);
	}

//---------------------------------------------------------------------------------------------------------------------

	@Test
	void testGetReviewsByItem() throws Exception {
		Review testReview = new Review(2, 1, 5, 10, null, 1, 1, null);
		List<Review> reviewList = new ArrayList<Review>();

		// given
		given(rs.getReviewsByItem(2))
			.willReturn(reviewList);

		// when
		MockHttpServletResponse response = mvc.perform(
			get("/reviewsByItem/2")
				.accept(MediaType.APPLICATION_JSON))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());

		String content = response.getContentAsString();
		Review[] reviews = gson.fromJson(content, Review[].class);
		assertTrue(reviews.length == 0);

	}

//---------------------------------------------------------------------------------------------------------------------

	@Test
	void testGetReviewsByRating() throws Exception {
		Review testReview = new Review(2, 1, 5, 10, null, 1, 1, null);
		List<Review> reviewList = new ArrayList<Review>();

		// given
		given(rs.getReviewsByRating(5))
			.willReturn(reviewList);

		// when
		MockHttpServletResponse response = mvc.perform(
			get("/reviewsByRating/5")
				.accept(MediaType.APPLICATION_JSON))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());

		String content = response.getContentAsString();
		Review[] reviews = gson.fromJson(content, Review[].class);
		assertTrue(reviews.length == 0);
	}

//---------------------------------------------------------------------------------------------------------------------

	@Test
	void testGetReviewsByDifficulty() throws Exception {
		Review testReview = new Review(2, 1, 5, 10, null, 1, 1, null);
		List<Review> reviewList = new ArrayList<Review>();

		// given
		given(rs.getReviewsByDifficulty(10))
			.willReturn(reviewList);

		// when
		MockHttpServletResponse response = mvc.perform(
			get("/reviewsByDifficulty/10")
				.accept(MediaType.APPLICATION_JSON))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());

		String content = response.getContentAsString();
		Review[] reviews = gson.fromJson(content, Review[].class);
		assertTrue(reviews.length == 0);
	}

//---------------------------------------------------------------------------------------------------------------------

	@Test
	void testAddReview() throws Exception {
		// when
		MockHttpServletResponse response = mvc.perform(
			post("/reviews")
				.contentType(MediaType.APPLICATION_JSON).content(
					jsonReview.write(new Review(2, 1, 5, 10, null, 1, 1, null)).getJson()
				))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());
	}

//---------------------------------------------------------------------------------------------------------------------

	@Test
	void testUpdateReview() throws Exception {
		Review testReview = new Review(2, 1, 5, 10, null, 1, 1, null);

		// when
		String input = gson.toJson(testReview);
		MockHttpServletResponse response = mvc.perform(
			put("/reviews/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(input))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());
//		assertEquals(content, "Review is updated successfully");

	}

//---------------------------------------------------------------------------------------------------------------------

	@Test
	void testDeleteReview() throws Exception {
		// when
		MockHttpServletResponse response = mvc.perform(
			delete("/reviews/1"))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());
//		assertEquals(content, "Product is deleted successfully");
	}

}
