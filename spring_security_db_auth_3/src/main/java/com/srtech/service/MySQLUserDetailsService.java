package com.srtech.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.srtech.entity.Profile;

/**
 * This is to demonstrate to fetch the user name and pwd from own tables rather than out of box spring security framework tables.
 */
@Service
public class MySQLUserDetailsService implements UserDetailsService {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Profile> optional= profileRepository.findByEmail(email);
		User user=null;
		String userName,pwd=null;
		List<GrantedAuthority> authorities=null;
		if(optional.isPresent()) {
			Profile profile = optional.get();
			userName=profile.getEmail();
			pwd=profile.getPwd();
			authorities=new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(profile.getRole()));
		}else {
			throw new UsernameNotFoundException("No user found with email "+email);
		}
		return new User(userName, pwd, authorities);
	}

}
