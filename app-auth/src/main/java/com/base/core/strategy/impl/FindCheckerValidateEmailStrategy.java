package com.base.core.strategy.impl;

import com.base.constants.MessageAuth;
import com.base.core.business.impl.CheckCodeValidateEmailBusinessData;
import com.base.core.facade.impl.AuthUserFacade;
import com.base.core.strategy.IStrategy;
import com.base.domain.CheckCodeValidateEmail;
import com.base.domain.ValidateEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindCheckerValidateEmailStrategy implements IStrategy {

	@Autowired
	private AuthUserFacade facade;

	@Autowired
	private MessageAuth messageAuth;

	@Override
	public void execute() {

		CheckCodeValidateEmailBusinessData businessData = CheckCodeValidateEmailBusinessData
			.getStaticInstance(CheckCodeValidateEmailBusinessData.class);

		if (!businessData.isError()) {

			CheckCodeValidateEmail checkCodeValidateEmail = businessData.getCheckCodeValidateEmail();

			ValidateEmail validateEmailData = facade.findValidateEmail(checkCodeValidateEmail.getEmail());

			if (validateEmailData == null)
				businessData.setError(messageAuth.ERROR_USER_NOT_EXIST);

			if (validateEmailData != null && validateEmailData.isValidated())
				businessData.setError(messageAuth.ERROR_EMAIL_VALIDATED);

			businessData.setValidateEmailData(validateEmailData);
		}
	}

}
