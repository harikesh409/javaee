package com.example.JWT;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("harikesh".equals(username)) {
			// Password is password encoded with 10 rounds using Bcrypt
			return new User(username, "$2y$10$yWKiEti.8O9C.rM1U9/PV.1XodLXQnFXeVwOSlN4XM/kxO9P9PtVC",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("Usrname Not Found");
		}
	}

}
