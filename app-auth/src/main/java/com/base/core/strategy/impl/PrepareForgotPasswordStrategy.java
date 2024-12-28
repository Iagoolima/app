package com.base.core.strategy.impl;

import com.base.constants.NumberOfCodeGeneratorDigits;
import com.base.core.business.impl.ForgotPasswordBusinessData;
import com.base.core.strategy.IStrategy;
import com.base.domain.AuthUser;
import com.base.domain.ForgotPassword;
import com.base.utils.impl.GeneratedCodeAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrepareForgotPasswordStrategy implements IStrategy {

	@Autowired
	private NumberOfCodeGeneratorDigits numberOfCodeGeneratorDigits;

	@Autowired
	private GeneratedCodeAuth generatedCodeAuth;

	@Override
	public void execute() {

		ForgotPasswordBusinessData businessData = ForgotPasswordBusinessData
			.getStaticInstance(ForgotPasswordBusinessData.class);

		if (!businessData.isError()) {

			ForgotPassword forgotPassword = businessData.getForgotPassword();
			AuthUser authUser = businessData.getAuthUserData();

			forgotPassword.setIdAuthUser(authUser.getId());
			forgotPassword.setCode(generatedCodeAuth.generatedCode(numberOfCodeGeneratorDigits.DIGITS_FORGOT_PASSWORD));

			businessData.getTokenResponse().setAcessToken(forgotPassword.getTokenUpdate().toString());
		}
	}

}
