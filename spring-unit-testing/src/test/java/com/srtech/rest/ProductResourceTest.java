package com.srtech.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.srtech.entity.Product;
import com.srtech.service.ProductService;

//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(controllers =  {ProductResource.class})
class ProductResourceTest {

	private static final String BASE_URI="/api/products";
	
	@Autowired
	private ProductResource productResource; 
	
	private Product expectedProduct;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductService productService;
	
	//@Mock
	//private ProductRepository productRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		expectedProduct=new Product(1,"Apple 12",1400.00);
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
		
		//when(productRepository.findById(1)).thenReturn(Optional.of(expectedProduct));
		//when(productService.getProduct(1)).thenReturn(expectedProduct);
		
		mockMvc.perform(MockMvcRequestBuilders.get(BASE_URI+"/{productId}",1))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	
	}

	@Test
	public void contextLoads() throws Exception {
		assertThat(productResource).isNotNull();
	}
}
