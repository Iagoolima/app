package com.base.service.authUser.impl;

import com.base.domain.ValidateEmail;
import com.base.repository.ValidateEmailRepository;
import com.base.service.authUser.IValidateEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidateEmailService implements IValidateEmailService {

	@Autowired
	private ValidateEmailRepository repository;

	public void saveValidateEmail(ValidateEmail validateEmail) {
		Optional<ValidateEmail> optionalValidateEmail = repository.findByEmail(validateEmail.getEmail());
		if (optionalValidateEmail.isPresent()) {
			repository.delete(optionalValidateEmail.get());
		}
		repository.save(validateEmail);
	}

	public ValidateEmail checkValidValidatedEmail(String email) {
		Optional<ValidateEmail> optionalValidateEmail = repository.findByEmail(email);
		return optionalValidateEmail.orElse(null);
	}

	public ValidateEmail findValidateEmail(String email) {
		Optional<ValidateEmail> optionalValidateEmail = repository.findByEmail(email);
		return optionalValidateEmail.orElse(null);
	}

	public void updateStateValidateEmail(ValidateEmail validateEmail) {
		repository.save(validateEmail);
	}

	public void deleteValidateEmail(int id) {
		repository.deleteById(id);
	}

}
