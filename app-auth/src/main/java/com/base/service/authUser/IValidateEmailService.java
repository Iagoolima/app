package com.base.service.authUser;

import com.base.domain.ValidateEmail;

public interface IValidateEmailService {

	void saveValidateEmail(ValidateEmail validateEmail);

	ValidateEmail checkValidValidatedEmail(String email);

	ValidateEmail findValidateEmail(String email);

	void updateStateValidateEmail(ValidateEmail validateEmail);

	void deleteValidateEmail(int id);

}
