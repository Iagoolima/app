package com.base.service.authUser.impl;

import com.base.domain.AuthUser;
import com.base.domain.User;
import com.base.repository.AuthUserRepository;
import com.base.repository.UserRepository;
import com.base.service.authUser.IAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthUserService implements IAuthUserService {

	@Autowired
	private AuthUserRepository authUserRepository;

	@Autowired
	private UserRepository userRepository;

	public AuthUser searchDataAuthUser(String email) {

		Optional<AuthUser> authUserOptional = authUserRepository.findByEmail(email);

		return authUserOptional.orElse(null);
	}

	public boolean emailAvailabilityChecker(String email) {
		return authUserRepository.existsByEmail(email);
	}

	public void registerAuthUser(AuthUser authUser) {
		authUserRepository.save(authUser);
	}

	public User registerUser(User user) {
		return userRepository.save(user);
	}

	public AuthUser findAuthUser(UUID id) {
		Optional<AuthUser> authUserOptional = authUserRepository.findById(id);
		return authUserOptional.orElse(null);
	}

	public void saveAuthUser(AuthUser authUser) {
		authUserRepository.save(authUser);
	}

}
