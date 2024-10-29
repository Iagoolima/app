package com.base.service.security;

import com.base.config.CustomUserDetails;
import com.base.domain.AuthUser;
import com.base.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private AuthUserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AuthUser userFound = repository.findByEmail(email).orElse(null);
		if (userFound == null) {
			return null;
		}
		String password = userFound.getPassword() != null ? userFound.getPassword() : "";

		return new CustomUserDetails(
				userFound.getUser(),
				userFound.getEmail(),
				password,
				Collections.singletonList(new SimpleGrantedAuthority("USER"))
		);	}

}
