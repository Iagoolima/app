package com.base.core.strategy.impl;

import com.base.core.business.impl.ForgotPasswordBusinessData;
import com.base.core.facade.impl.AuthUserFacade;
import com.base.core.strategy.IStrategy;
import com.base.domain.BodyEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendEmailForgotPasswordStrategy implements IStrategy {

	@Autowired
	private AuthUserFacade facade;

	@Override
	public void execute() {

		ForgotPasswordBusinessData businessData = ForgotPasswordBusinessData
			.getStaticInstance(ForgotPasswordBusinessData.class);

		if (!businessData.isError()) {

			BodyEmail bodyEmail = businessData.getBodyEmail();

			facade.sendEmail(bodyEmail);

		}
	}

}
