package com.srtech.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.srtech.entity.Profile;
import com.srtech.repository.ProfileRepository;

@Service
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		Optional<Profile> optional= profileRepository.findByEmail(authentication.getName());
		User user=null;
		String userName=authentication.getName(),pwd=authentication.getCredentials().toString();
		List<GrantedAuthority> authorities=null;
		if(optional.isPresent() && passwordEncoder.matches(pwd, optional.get().getPwd())) {
			Profile profile = optional.get();
			authorities=new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(profile.getRole()));
		}else {
			throw new UsernameNotFoundException("No user found with email "+authentication.getName());
		}
		//user = new User(userName, pwd, authorities);
		return new UsernamePasswordAuthenticationToken(userName,pwd,authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
