package com.srtech.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.srtech.entity.Profile;


@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {
	
	Optional<Profile> findByEmail(String email);

}
