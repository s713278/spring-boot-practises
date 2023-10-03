package com.srtech.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class MathServiceTest {

	@Autowired
	private MathService mathService;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	//@Test
	void testGetFebancciSeries() {
		fail("Not yet implemented");
	}

	@Test
	void testGetLuckyNumber() {
		String luckyNo= mathService.getLuckyNumber("Test");
		assertNotNull(luckyNo);
	}
	
	void testPositiveAdd() {
		int sum=mathService.add(10,10);
		assertEquals(20, sum,"Sum of 10,10 should be 20");
	}
	
	void testNegativeAdd() {
		int sum=mathService.add(10,10);
		assertEquals(15, sum,"Sum of 10,10 should npt be 15");
	}

}
