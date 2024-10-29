package com.base.service.authUser.impl;

import com.base.domain.ForgotPassword;
import com.base.repository.ForgotPasswordRepository;
import com.base.service.authUser.IForgotPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ForgotPasswordService implements IForgotPasswordService {

	@Autowired
	private ForgotPasswordRepository repository;

	public void saveForgotPassword(ForgotPassword forgotPassword) {
		Optional<ForgotPassword> optionalForgotPassword = repository.findByEmail(forgotPassword.getEmail());
		if (optionalForgotPassword.isPresent()) {
			repository.delete(optionalForgotPassword.get());
		}
		repository.save(forgotPassword);
	}

	public ForgotPassword findForgotPassword(UUID tokenUpdate) {
		Optional<ForgotPassword> optionalForgotPassword = repository.findByTokenUpdate(tokenUpdate);
		return optionalForgotPassword.orElse(null);
	}

	public void updateStateForgotPassword(ForgotPassword forgotPasswordData) {
		repository.save(forgotPasswordData);
	}

	public void deleteForgotPassword(int id) {
		repository.deleteById(id);
	}

}
