package com.base.core.strategy.impl;

import com.base.constants.MessageAuth;
import com.base.core.business.impl.BusinessApplication;
import com.base.core.business.impl.ValidateEmailBusinessData;
import com.base.core.facade.impl.AuthUserFacade;
import com.base.core.strategy.IStrategy;
import com.base.domain.ValidateEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateEmailAvailabilityCheckerStrategy implements IStrategy {

	@Autowired
	private AuthUserFacade facade;

	@Autowired
	private MessageAuth messageAuth;

	@Override
	public void execute() {

		ValidateEmailBusinessData businessData = BusinessApplication.getStaticInstance(ValidateEmailBusinessData.class);

		if (!businessData.isError()) {

			ValidateEmail validateEmail = businessData.getValidateEmail();

			boolean userExists = facade.emailAvailabilityChecker(validateEmail.getEmail());

			if (userExists) {
				businessData.setError(messageAuth.ERROR_EMAIL_ALREADY_EXISTS);
			}

		}

	}

}
