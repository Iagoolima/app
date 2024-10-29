package com.base.core.strategy.impl;

import com.base.core.business.impl.UpdatePasswordForgotPasswordBusinessData;
import com.base.core.facade.impl.AuthUserFacade;
import com.base.core.strategy.IStrategy;
import com.base.domain.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdatePasswordForgotPasswordStrategy implements IStrategy {

	@Autowired
	private AuthUserFacade facade;

	@Override
	public void execute() {

		UpdatePasswordForgotPasswordBusinessData businessData = UpdatePasswordForgotPasswordBusinessData
			.getStaticInstance(UpdatePasswordForgotPasswordBusinessData.class);

		if (!businessData.isError()) {

			AuthUser authUserData = businessData.getAuthUserData();

			facade.saveAuthUser(authUserData);

		}

	}

}
