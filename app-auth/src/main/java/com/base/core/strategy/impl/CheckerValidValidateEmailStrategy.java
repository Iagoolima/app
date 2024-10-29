package com.base.core.strategy.impl;

import com.base.constants.MessageAuth;
import com.base.core.business.impl.RegisterBusinessData;
import com.base.core.facade.impl.AuthUserFacade;
import com.base.core.strategy.IStrategy;
import com.base.domain.AuthUser;
import com.base.domain.ValidateEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckerValidValidateEmailStrategy implements IStrategy {

	@Autowired
	private AuthUserFacade facade;

	@Autowired
	private MessageAuth messageAuth;

	@Override
	public void execute() {

		RegisterBusinessData businessData = RegisterBusinessData.getStaticInstance(RegisterBusinessData.class);

		if (!businessData.isError()) {

			AuthUser authUser = businessData.getAuthUser();

			ValidateEmail validateEmailData = facade.checkValidValidatedEmail(authUser.getEmail());

			if (validateEmailData == null)
				businessData.setError(messageAuth.ERROR_USER_NOT_FOUND);

			if (validateEmailData != null && !validateEmailData.isValidated())
				businessData.setError(messageAuth.ERROR_EMAIL_NOT_VALIDATED);

			businessData.setValidateEmailData(validateEmailData);

		}

	}

}
