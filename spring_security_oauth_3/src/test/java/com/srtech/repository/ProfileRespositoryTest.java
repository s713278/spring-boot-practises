package com.srtech.repository;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.srtech.entity.NBCProfile;

@SpringBootTest
class ProfileRespositoryTest {

	@Autowired
	private ProfileRespository profileRespository;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFindByEmailId() {
		Optional<NBCProfile> nbcProfile= profileRespository.findById(1);
		System.out.println("nbcProfile \t"+nbcProfile);
		//assertTrue(profileRespository.findAll().iterator().hasNext());
	}

}
