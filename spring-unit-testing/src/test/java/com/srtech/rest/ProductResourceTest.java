package com.srtech.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.srtech.repository.ProductRepository;
import com.srtech.service.ProductService;

@SpringBootTest
@AutoConfigureMockMvc
class ProductResourceTest {

	private static final String BASE_URI="/api/products";
	@Autowired
	private ProductResource productResource; 
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	private ProductService productService;
	
	@Mock
	private ProductRepository productRepository;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetProducts() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get(BASE_URI+"/"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void testGetProduct()  throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get(BASE_URI+"/1"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	
	}

	@Test
	public void contextLoads() throws Exception {
		assertThat(productResource).isNotNull();
	}
}
