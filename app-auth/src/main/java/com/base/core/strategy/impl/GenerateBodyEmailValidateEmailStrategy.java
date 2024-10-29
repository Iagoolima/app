package com.base.core.strategy.impl;

import com.base.constants.MessageAuth;
import com.base.core.business.impl.ValidateEmailBusinessData;
import com.base.core.strategy.IStrategy;
import com.base.domain.BodyEmail;
import com.base.domain.ValidateEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class GenerateBodyEmailValidateEmailStrategy implements IStrategy {

	@Autowired
	private MessageAuth messageAuth;

	@Override
	public void execute() {

		ValidateEmailBusinessData businessData = ValidateEmailBusinessData
			.getStaticInstance(ValidateEmailBusinessData.class);

		if (!businessData.isError()) {
			ValidateEmail validateEmail = businessData.getValidateEmail();
			BodyEmail bodyEmail = businessData.getBodyEmail();
			bodyEmail.setEmail(validateEmail.getEmail());
			bodyEmail.setTitle(messageAuth.SEND_VALIDATE_EMAIL_TITLE);
			bodyEmail.setMessage(MessageFormat.format(messageAuth.SEND_VALIDATE_EMAIL_MESSAGE, validateEmail.getCode()));
		}
	}

}
