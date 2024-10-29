package com.base.core.strategy.impl;

import com.base.core.business.impl.CheckCodeForgotPasswordBusinessData;
import com.base.core.business.impl.CheckCodeValidateEmailBusinessData;
import com.base.core.facade.impl.AuthUserFacade;
import com.base.core.strategy.IStrategy;
import com.base.domain.ForgotPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateStateForgotPassowordStrategy implements IStrategy {

	@Autowired
	private AuthUserFacade facade;

	@Override
	public void execute() {

		CheckCodeForgotPasswordBusinessData businessData = CheckCodeValidateEmailBusinessData
			.getStaticInstance(CheckCodeForgotPasswordBusinessData.class);

		if (!businessData.isError()) {

			ForgotPassword forgotPasswordData = businessData.getForgotPasswordData();

			forgotPasswordData.setValidated(true);

			facade.updateStateForgotPassword(forgotPasswordData);
		}
	}

}
