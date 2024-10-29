package com.base.core.strategy.impl;

import com.base.constants.MessageAuth;
import com.base.core.business.impl.UpdatePasswordForgotPasswordBusinessData;
import com.base.core.facade.impl.AuthUserFacade;
import com.base.core.strategy.IStrategy;
import com.base.domain.AuthUser;
import com.base.domain.ForgotPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAuthUserForgotPasswordStartegy implements IStrategy {

	@Autowired
	private AuthUserFacade facade;

	@Autowired
	private MessageAuth messageAuth;

	@Override
	public void execute() {

		UpdatePasswordForgotPasswordBusinessData businessData = UpdatePasswordForgotPasswordBusinessData
			.getStaticInstance(UpdatePasswordForgotPasswordBusinessData.class);

		if (!businessData.isError()) {

			ForgotPassword forgotPasswordData = businessData.getForgotPasswordData();

			AuthUser authUserData = facade.findAuthUser(forgotPasswordData.getIdAuthUser());

			if (authUserData == null)
				businessData.setError(messageAuth.ERROR_USER_NOT_FOUND);

			businessData.setAuthUserData(authUserData);
		}

	}

}
