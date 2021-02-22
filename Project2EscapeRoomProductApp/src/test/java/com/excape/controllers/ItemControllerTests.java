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

import com.excape.beans.Item;
import com.excape.services.ItemServices;
import com.google.gson.Gson;

@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@SpringBootTest(classes = com.excape.app.Project2EscapeRoomProductAppApplication.class)
class ItemControllerTests {

	@Autowired
	private Gson gson;

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ItemServices is;

	@Autowired
	private JacksonTester<Item> jsonItem;

//---------------------------------------------------------------------------------------------------------------------

	@Test
	void testGetItemById() throws Exception {
		// given
		given(is.getItem(1))
			.willReturn(new Item("LED Aquarium Puzzle", "Underwater labyrinth with LED guide markers",
				new BigDecimal(5384000), "83 x 90 x 30", 39, 40, 17.5, "Logic Puzzles", new BigDecimal(399.99), 3));

		// when
		MockHttpServletResponse response = mvc.perform(
			get("/items/1")
				.accept(MediaType.APPLICATION_JSON))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());
		assertEquals(response.getContentAsString(),
			jsonItem.write(new Item("LED Aquarium Puzzle", "Underwater labyrinth with LED guide markers",
				new BigDecimal(5384000), "83 x 90 x 30", 39, 40, 17.5, "Logic Puzzles", new BigDecimal(399.99), 3))
				.getJson()
		);
	}

//---------------------------------------------------------------------------------------------------------------------
// fix this???

	@Test
	void testGetItemByName() throws Exception {
		Item lap = new Item("LED Aquarium Puzzle", "Underwater labyrinth with LED guide markers",
			new BigDecimal(5384000), "83 x 90 x 30", 39, 40, 17.5, "Logic Puzzles", new BigDecimal(399.99), 3);

		List<Item> itemmatch = new ArrayList<Item>();
		itemmatch.add(lap);

		// given
		given(is.getItem("LED Aquarium Puzzle"))
			.willReturn(itemmatch);
//			.willReturn(lap);

		// when
		MockHttpServletResponse response = mvc.perform(
			get("/items/search?name=LED Aquarium Puzzle")
				.accept(MediaType.APPLICATION_JSON))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());
		assertEquals(itemmatch.size(), 2);
//		assertEquals(response.getContentAsString(),
//			jsonItem.write(new Item("LED Aquarium Puzzle", "Underwater labyrinth with LED guide markers",
//				new BigDecimal(5384000), "83 x 90 x 30", 39, 40, 17.5, "Logic Puzzles", new BigDecimal(399.99), 3))
//				.getJson()
//		);

	}

//---------------------------------------------------------------------------------------------------------------------

	@Test
	void testGetAllItems() throws Exception {
		// when
		MockHttpServletResponse response = mvc.perform(
			get("/items")
				.accept(MediaType.APPLICATION_JSON))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());

		String content = response.getContentAsString();
		Item[] items = gson.fromJson(content, Item[].class);
		assertTrue(items.length == 0);
	}

//---------------------------------------------------------------------------------------------------------------------

	@Test
	void testAddItem() throws Exception {
		// when
		MockHttpServletResponse response = mvc.perform(
			post("/items")
				.contentType(MediaType.APPLICATION_JSON).content(
					jsonItem.write(new Item("LED Aquarium Puzzle", "Underwater labyrinth with LED guide markers",
						new BigDecimal(5384000), "83 x 90 x 30", 39, 40, 17.5, "Logic Puzzles", new BigDecimal(399.99),
						3)).getJson()
				))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());
	}

//---------------------------------------------------------------------------------------------------------------------

	@Test
	void testUpdateItem() throws Exception {
		Item lapChange = new Item("LED Aquarium Puzzle",
			"Underwater labyrinth with LED guide markers.  Now with sharks!", new BigDecimal(5384000), "83 x 90 x 30",
			39, 40, 17.5, "Logic Puzzles", new BigDecimal(399.99), 3);

		// when
		String input = gson.toJson(lapChange);
		MockHttpServletResponse response = mvc.perform(
			put("/items/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(input))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());
//		assertEquals(content, "Item is updated successfully");
	}

//---------------------------------------------------------------------------------------------------------------------

	@Test
	void testDeleteItem() throws Exception {
		// when
		MockHttpServletResponse response = mvc.perform(
			delete("/items/1"))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());
//		assertEquals(content, "Product is deleted successfully");
	}

}
