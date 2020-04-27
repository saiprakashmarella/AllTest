package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserAuthenticationPrinciple;
import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class UserAuthenticationService implements UserDetailsService {
	
	@Autowired
	private UsersRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
			Users user=repo.findByUsername(username);
			if(user==null) {
				throw new UsernameNotFoundException("User not found");
			}
			
		return new UserAuthenticationPrinciple(user);
	}
}
