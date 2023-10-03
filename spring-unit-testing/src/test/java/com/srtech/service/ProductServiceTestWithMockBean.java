package com.srtech.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.srtech.entity.Product;
import com.srtech.repository.ProductRepository;

/**
 * Demonstration of MockBean and Autowired of Springboot testing framework
 * MockBean
 */
@SpringBootTest
class ProductServiceTestWithMockBean {

	// @Mock
	@MockBean
	private ProductRepository productRepository;

	// @InjectMocks
	@Autowired
	private ProductService productService;

	Product expectedProduct = null;

	@BeforeEach
	void setUp() throws Exception {
		expectedProduct = new Product(1, "Apple 12", 1400.00);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// @Test
	void testGetProducts() {
		// fail("Not yet implemented");
	}

	@DisplayName("Search a product with ID- 1")
	@Test
	void test_GetProduct_For_Id_1() {
		Integer productId = 1;
		when(productRepository.findById(productId)).thenReturn(Optional.of(expectedProduct));
		Product actual = productService.getProduct(productId);
		assertEquals(expectedProduct, actual);
		verify(productRepository, times(1)).findById(productId);
		// fail("Not yet implemented");
	}

	@DisplayName("List All Products")
	@Test
	public void test_Get_App_Products() {
		when(productService.getProducts()).thenReturn(List.of(expectedProduct));
		List<Product> products=productService.getProducts();
		assertEquals(1, products.size());
		verify(productRepository,times(1)).findAll();
	}

}
