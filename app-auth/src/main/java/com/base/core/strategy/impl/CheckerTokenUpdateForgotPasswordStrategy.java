package com.base.core.strategy.impl;

import com.base.constants.MessageAuth;
import com.base.core.business.impl.CheckCodeForgotPasswordBusinessData;
import com.base.core.facade.impl.AuthUserFacade;
import com.base.core.strategy.IStrategy;
import com.base.domain.CheckCodeForgotPassword;
import com.base.domain.ForgotPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CheckerTokenUpdateForgotPasswordStrategy implements IStrategy {

	@Autowired
	private AuthUserFacade facade;

	@Autowired
	private MessageAuth messageAuth;

	@Override
	public void execute() {

		CheckCodeForgotPasswordBusinessData businessData = CheckCodeForgotPasswordBusinessData
			.getStaticInstance(CheckCodeForgotPasswordBusinessData.class);

		if (!businessData.isError()) {

			CheckCodeForgotPassword checkCodeForgotPassword = businessData.getCheckCodeForgotPassword();

			ForgotPassword forgotPasswordData = facade
				.findForgotPassword(UUID.fromString(checkCodeForgotPassword.getToken()));

			if (forgotPasswordData == null)
				businessData.setError(messageAuth.ERROR_TOKEN_UPDATE_NOT_EXISTS);

			businessData.setForgotPasswordData(forgotPasswordData);

		}
	}

}
