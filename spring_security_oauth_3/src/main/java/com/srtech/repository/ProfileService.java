package com.srtech.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srtech.entity.NBCProfile;



@Service
public class ProfileService implements UserDetailsService {

	@Autowired
	private ProfileRespository profileRespository;
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		
		List<NBCProfile> profile=profileRespository.findByEmailId(emailId.toLowerCase());
		User user=null;
		if(!profile.isEmpty()) {
			NBCProfile profile1= profile.get(0);
			SimpleGrantedAuthority authority=new SimpleGrantedAuthority(profile1.getRole());
			user=new User(profile1.getEmailId(),profile1.getPwd(),List.of(authority));
		}
		else {
			throw new UsernameNotFoundException("No user registred with email "+emailId);
		}
		return user;
	}

}
