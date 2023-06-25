package com.mx100.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mx100.model.MasterUser;
import com.mx100.repository.MasterUserRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private MasterUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MasterUser user = userRepository.findOneByUsername(username);
		
		if (user != null) {
			return user;			
		}
		
		throw new UsernameNotFoundException(username);		
	}

}
