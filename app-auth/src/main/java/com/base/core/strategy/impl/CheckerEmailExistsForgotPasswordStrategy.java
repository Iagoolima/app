package com.base.core.strategy.impl;

import com.base.constants.MessageAuth;
import com.base.core.business.impl.ForgotPasswordBusinessData;
import com.base.core.facade.impl.AuthUserFacade;
import com.base.core.strategy.IStrategy;
import com.base.domain.AuthUser;
import com.base.domain.ForgotPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckerEmailExistsForgotPasswordStrategy implements IStrategy {

	@Autowired
	private AuthUserFacade facade;

	@Autowired
	private MessageAuth messageAuth;

	@Override
	public void execute() {

		ForgotPasswordBusinessData businessData = ForgotPasswordBusinessData
			.getStaticInstance(ForgotPasswordBusinessData.class);

		if (!businessData.isError()) {

			ForgotPassword forgotPassword = businessData.getForgotPassword();

			AuthUser authUserData = facade.searchDataAuthUser(forgotPassword.getEmail());

			if (authUserData == null)
				businessData.setError(messageAuth.ERROR_EMAIL_ALREADY_EXISTS);

			businessData.setAuthUserData(authUserData);
		}
	}

}
