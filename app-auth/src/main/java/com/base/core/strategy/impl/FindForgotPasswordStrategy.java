package com.base.core.strategy.impl;

import com.base.constants.MessageAuth;
import com.base.core.business.impl.UpdatePasswordForgotPasswordBusinessData;
import com.base.core.facade.impl.AuthUserFacade;
import com.base.core.strategy.IStrategy;
import com.base.domain.ForgotPassword;
import com.base.domain.UpdatePasswordForgotPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FindForgotPasswordStrategy implements IStrategy {

	@Autowired
	private AuthUserFacade facade;

	@Autowired
	private MessageAuth messageAuth;

	@Override
	public void execute() {

		UpdatePasswordForgotPasswordBusinessData businessData = UpdatePasswordForgotPasswordBusinessData
			.getStaticInstance(UpdatePasswordForgotPasswordBusinessData.class);

		if (!businessData.isError()) {

			UpdatePasswordForgotPassword updatePasswordForgotPassword = businessData.getUpdatePasswordForgotPassword();

			ForgotPassword forgotPasswordData = facade
				.findForgotPassword(UUID.fromString(updatePasswordForgotPassword.getTokenUpdate()));

			if (forgotPasswordData == null)
				businessData.setError(messageAuth.ERROR_TOKEN_UPDATE_NOT_EXISTS);

			if (forgotPasswordData != null && !forgotPasswordData.isValidated())
				businessData.setError(messageAuth.ERROR_TOKEN_UPDATE_NOT_VALIDATED);

			businessData.setForgotPasswordData(forgotPasswordData);
		}
	}

}
