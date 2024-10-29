package com.base.core.strategy.impl;

import com.base.constants.MessageAuth;
import com.base.core.business.impl.CheckCodeForgotPasswordBusinessData;
import com.base.core.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckerCodeForgotPasswordStrategy implements IStrategy {

	@Autowired
	private MessageAuth messageAuth;

	@Override
	public void execute() {

		CheckCodeForgotPasswordBusinessData businessData = CheckCodeForgotPasswordBusinessData
			.getStaticInstance(CheckCodeForgotPasswordBusinessData.class);

		if (!businessData.isError()) {

			String codeInsertion = businessData.getCheckCodeForgotPassword().getCode();
			String codeDate = businessData.getForgotPasswordData().getCode();

			if (!codeInsertion.equals(codeDate))
				businessData.setError(messageAuth.ERROR_CODE_INCORRECT);
		}
	}

}
