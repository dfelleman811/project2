package com.excape.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

import com.excape.beans.Vendor;
import com.excape.services.VendorServices;
import com.google.gson.Gson;

//@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@SpringBootTest(classes = com.excape.app.Project2EscapeRoomProductAppApplication.class)
//@WebMvcTest(VendorController.class)
class VendorControllerTests {

	@Autowired
	private Gson gson;

	@Autowired
	private MockMvc mvc;

	@MockBean
	private VendorServices vs;

	@Autowired
	private JacksonTester<Vendor> jsonVendor;

//---------------------------------------------------------------------------------------------------------------------

	@Test
	public void testGetVendorById() throws Exception {
		// given
		given(vs.getVendor(1))
			.willReturn(new Vendor("Knight Mare Enterprises", "Kayla Knight", "contact@knightmareenterprises",
				new BigDecimal(1234567890), "knightmareenterprises.com", "64 Chess Sq.", null, "New York City", "NY",
				10012, null));

		// when
		MockHttpServletResponse response = mvc.perform(
			get("/vendors/1")
				.accept(MediaType.APPLICATION_JSON))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());
		assertEquals(response.getContentAsString(),
			jsonVendor.write(new Vendor("Knight Mare Enterprises", "Kayla Knight", "contact@knightmareenterprises",
				new BigDecimal(1234567890), "knightmareenterprises.com", "64 Chess Sq.", null, "New York City", "NY",
				10012, null)).getJson()
		);

	}

//---------------------------------------------------------------------------------------------------------------------

//	@Test
//	public void testGetVendorByIdWhenDoesNotExist() throws Exception {
//		// given
//		given(vs.getVendor(10))
//			.willThrow(new NonExistingVendorException());
//
//		// when
//		MockHttpServletResponse response = mvc.perform(
//			get("/vendors/10")
//				.accept(MediaType.APPLICATION_JSON))
//			.andReturn().getResponse();
//
//		// then
//		assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
//		assertThat(response.getContentAsString()).isEmpty();
//
//	}

//---------------------------------------------------------------------------------------------------------------------

	@Test
	public void testGetVendorByName() throws Exception {
		// given
		given(vs.getVendor("Knight Mare Enterprises"))
			.willReturn(new Vendor("Knight Mare Enterprises", "Kayla Knight", "contact@knightmareenterprises",
				new BigDecimal(1234567890), "knightmareenterprises.com", "64 Chess Sq.", null, "New York City", "NY",
				10012, null));

		// when
		MockHttpServletResponse response = mvc.perform(
			get("/vendors/search?name=Knight Mare Enterprises")
				.accept(MediaType.APPLICATION_JSON))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());
		assertEquals(response.getContentAsString(),
			jsonVendor.write(new Vendor("Knight Mare Enterprises", "Kayla Knight", "contact@knightmareenterprises",
				new BigDecimal(1234567890), "knightmareenterprises.com", "64 Chess Sq.", null, "New York City", "NY",
				10012, null)).getJson()
		);

	}

//---------------------------------------------------------------------------------------------------------------------
// why is the vendors list length 0??

	@Test
	public void testGetAllVendors() throws Exception {
		// when
		MockHttpServletResponse response = mvc.perform(
			get("/vendors")
				.accept(MediaType.APPLICATION_JSON))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());

		String content = response.getContentAsString();
		Vendor[] vendors = gson.fromJson(content, Vendor[].class);
		assertTrue(vendors.length == 0);

	}

// ---------------------------------------------------------------------------------------------------------------------

	@Test
	public void testAddVendor() throws Exception {
		// when
		MockHttpServletResponse response = mvc.perform(
			post("/vendors")
				.contentType(MediaType.APPLICATION_JSON).content(
					jsonVendor.write(new Vendor("Knight Mare Enterprises", "Kayla Knight",
						"contact@knightmareenterprises", new BigDecimal(1234567890), "knightmareenterprises.com",
						"64 Chess Sq.", null, "New York City", "NY", 10012, null)).getJson()
				))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());

	}

// ---------------------------------------------------------------------------------------------------------------------

	@Test
	public void testUpdateVendor() throws Exception {
		Vendor kme = new Vendor("Knight Mare Enterprises", "Kayla Knight", "kayla@knightmareenterprises",
			new BigDecimal(1234567890), "knightmareenterprises.com", "64 Chess Sq.", null, "New York City", "NY", 10012,
			null);

		// when
		String input = gson.toJson(kme);
		MockHttpServletResponse response = mvc.perform(
			put("/vendors/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(input))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());
//		assertEquals(content, "Vendor is updated successfully");

	}

// ---------------------------------------------------------------------------------------------------------------------

	@Test
	public void testDeleteVendor() throws Exception {
		// when
		MockHttpServletResponse response = mvc.perform(
			delete("/vendors/1"))
			.andReturn().getResponse();

		// then
		assertEquals(response.getStatus(), HttpStatus.OK.value());
//		assertEquals(content, "Product is deleted successfully");

	}

}
