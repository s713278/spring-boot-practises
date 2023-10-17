package com.srtech.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.srtech.entity.NBCProfile;

@Repository
public interface ProfileRespository extends CrudRepository<NBCProfile, Integer> {

	public List<NBCProfile> findByEmailId(String emailId);
}
