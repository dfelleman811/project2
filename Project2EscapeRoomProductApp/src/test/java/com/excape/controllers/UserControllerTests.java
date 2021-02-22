package com.excape.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import java.io.IOException;
import java.math.BigDecimal;
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

import com.excape.beans.User;
import com.excape.services.UserService;
import com.google.gson.Gson;

@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@SpringBootTest(classes = com.excape.app.Project2EscapeRoomProductAppApplication.class)
class UserControllerTests {

	@Autowired
	private Gson gson;

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService us;

	@Autowired
	private JacksonTester<User> jsonUser;

	@Test
	void testAddUser() throws IOException, Exception {
		// when
		MockHttpServletResponse response = mvc.perform(
			post("/users")
				.contentType(MediaType.APPLICATION_JSON).content(
					jsonUser.write(new User("Kayla", "Knight", "Knight Mare Enterprises",
						"kayla@knightmareenterprises.com", new BigDecimal(1234567890), "64 Chess Sq.", null,
						"New York City", "NY", "United States", 10012, "kaylaknight", "password", 0)).getJson()
				))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());

	}

//---------------------------------------------------------------------------------------------------------------------

	@Test
	void testGetUserById() throws Exception {
		// given
		given(us.getUser(1))
			.willReturn(new User("Kayla", "Knight", "Knight Mare Enterprises", "kayla@knightmareenterprises.com",
				new BigDecimal(1234567890), "64 Chess Sq.", null, "New York City", "NY", "United States", 10012,
				"kaylaknight", "password", 0));

		// when
		MockHttpServletResponse response = mvc.perform(
			get("/users/1")
				.accept(MediaType.APPLICATION_JSON))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());
		assertEquals(response.getContentAsString(),
			jsonUser.write(new User("Kayla", "Knight", "Knight Mare Enterprises", "kayla@knightmareenterprises.com",
				new BigDecimal(1234567890), "64 Chess Sq.", null, "New York City", "NY", "United States", 10012,
				"kaylaknight", "password", 0)).getJson()
		);
	}

//---------------------------------------------------------------------------------------------------------------------

//	@Test
//	void testGetUserByEmail() throws Exception {
//		// given
//		given(us.getUser(1))
//			.willReturn(new User("Kayla", "Knight", "Knight Mare Enterprises", "kayla@knightmareenterprises.com",
//				new BigDecimal(1234567890), "64 Chess Sq.", null, "New York City", "NY", "United States", 10012,
//				"kaylaknight", "password", 0));
//
//		// when
//		MockHttpServletResponse response = mvc.perform(
//			get("/usersByEmail/kayla@knightmareenterprises.com")
//				.accept(MediaType.APPLICATION_JSON))
//			.andReturn().getResponse();
//
//		// then
//		assertEquals(response.getStatus(), HttpStatus.OK.value());
//		assertEquals(response.getContentAsString(),
//			jsonUser.write(new User("Kayla", "Knight", "Knight Mare Enterprises", "kayla@knightmareenterprises.com",
//				new BigDecimal(1234567890), "64 Chess Sq.", null, "New York City", "NY", "United States", 10012,
//				"kaylaknight", "password", 0)).getJson()
//		);
//	}

//---------------------------------------------------------------------------------------------------------------------

	@Test
	void testGetAllUsers() throws Exception {
		// when
		MockHttpServletResponse response = mvc.perform(
			get("/users")
				.accept(MediaType.APPLICATION_JSON))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());

		String content = response.getContentAsString();
		User[] users = gson.fromJson(content, User[].class);
		assertTrue(users.length == 0);
	}

//---------------------------------------------------------------------------------------------------------------------

	@Test
	void testGetUsersByLastName() throws Exception {
		// given
		given(us.getUser(1))
			.willReturn(new User("Kayla", "Knight", "Knight Mare Enterprises", "kayla@knightmareenterprises.com",
				new BigDecimal(1234567890), "64 Chess Sq.", null, "New York City", "NY", "United States", 10012,
				"kaylaknight", "password", 0));

		// when
		MockHttpServletResponse response = mvc.perform(
			get("/users/search?lastName=Knight")
				.accept(MediaType.APPLICATION_JSON))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());
//		assertEquals(response.getContentAsString(),
//			jsonUser.write(new User("Kayla", "Knight", "Knight Mare Enterprises", "kayla@knightmareenterprises.com",
//				new BigDecimal(1234567890), "64 Chess Sq.", null, "New York City", "NY", "United States", 10012,
//				"kaylaknight", "password", 0)).getJson()
//		);
	}

//---------------------------------------------------------------------------------------------------------------------

	@Test
	void testGetUsersByBusinessName() throws Exception {
		// given
		given(us.getUser(1))
			.willReturn(new User("Kayla", "Knight", "Knight Mare Enterprises", "kayla@knightmareenterprises.com",
				new BigDecimal(1234567890), "64 Chess Sq.", null, "New York City", "NY", "United States", 10012,
				"kaylaknight", "password", 0));

		// when
		MockHttpServletResponse response = mvc.perform(
			get("/users/searchByBusiness?businessName=Knight Mare Enterprises")
				.accept(MediaType.APPLICATION_JSON))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());
//		assertEquals(response.getContentAsString(),
//			jsonUser.write(new User("Kayla", "Knight", "Knight Mare Enterprises", "kayla@knightmareenterprises.com",
//				new BigDecimal(1234567890), "64 Chess Sq.", null, "New York City", "NY", "United States", 10012,
//				"kaylaknight", "password", 0)).getJson()
//		);
	}

//---------------------------------------------------------------------------------------------------------------------

	@Test
	void testUpdateUser() throws Exception {
		User kayla = new User("Kayla", "Knight", "Knight Mare Enterprises", "kayla@knightmareenterprises.com",
			new BigDecimal(1234567890), "64 Chess Sq.", null, "New York City", "NY", "United States", 10012,
			"kknight", "password", 0);

		// when
		String input = gson.toJson(kayla);
		MockHttpServletResponse response = mvc.perform(
			put("/users/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(input))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());
//		assertEquals(content, "User is updated successfully");
	}

//---------------------------------------------------------------------------------------------------------------------

	@Test
	void testDeleteUser() throws Exception {
		// when
		MockHttpServletResponse response = mvc.perform(
			delete("/vendors/1"))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());
//			assertEquals(content, "Product is deleted successfully");
	}

}
