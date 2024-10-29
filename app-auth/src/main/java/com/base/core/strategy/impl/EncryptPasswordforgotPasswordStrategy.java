package com.base.core.strategy.impl;

import com.base.core.business.impl.UpdatePasswordForgotPasswordBusinessData;
import com.base.core.strategy.IStrategy;
import com.base.domain.AuthUser;
import com.base.domain.UpdatePasswordForgotPassword;
import com.base.utils.impl.EncryptBCript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EncryptPasswordforgotPasswordStrategy implements IStrategy {

	@Autowired
	private EncryptBCript encription;

	@Override
	public void execute() {

		UpdatePasswordForgotPasswordBusinessData businessData = UpdatePasswordForgotPasswordBusinessData
			.getStaticInstance(UpdatePasswordForgotPasswordBusinessData.class);

		if (!businessData.isError()) {

			UpdatePasswordForgotPassword updatePasswordForgotPassword = businessData.getUpdatePasswordForgotPassword();
			AuthUser authUserData = businessData.getAuthUserData();

			authUserData.setPassword(
					encription.encryptPassword(updatePasswordForgotPassword.getPassword(), authUserData.getId()));

		}

	}

}
