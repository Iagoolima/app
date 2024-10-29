package com.base.core.strategy.impl;

import com.base.constants.MessageAuth;
import com.base.core.business.impl.ForgotPasswordBusinessData;
import com.base.core.strategy.IStrategy;
import com.base.domain.BodyEmail;
import com.base.domain.ForgotPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class GenerateBodyForgotPasswordStrategy implements IStrategy {

	@Autowired
	private MessageAuth messageAuth;

	@Override
	public void execute() {

		ForgotPasswordBusinessData businessData = ForgotPasswordBusinessData
			.getStaticInstance(ForgotPasswordBusinessData.class);

		if (!businessData.isError()) {

			ForgotPassword forgotPassword = businessData.getForgotPassword();

			BodyEmail bodyEmail = businessData.getBodyEmail();
			bodyEmail.setEmail(forgotPassword.getEmail());
			bodyEmail.setTitle(messageAuth.SEND_REPLACE_PASSWORD_TITLE);
			bodyEmail.setMessage(MessageFormat.format(messageAuth.SEND_REPLACE_PASSWORD_MESSAGE, forgotPassword.getCode()));

		}
	}

}
