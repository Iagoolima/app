package com.base.core.strategy.impl;

import com.base.constants.MessageAuth;
import com.base.core.business.impl.CheckCodeValidateEmailBusinessData;
import com.base.core.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckerCodeValidateEmailStrategy implements IStrategy {

	@Autowired
	private MessageAuth messageAuth;

	@Override
	public void execute() {

		CheckCodeValidateEmailBusinessData businessData = CheckCodeValidateEmailBusinessData
			.getStaticInstance(CheckCodeValidateEmailBusinessData.class);

		if (!businessData.isError()) {

			String codeInsertion = businessData.getCheckCodeValidateEmail().getCode();
			String codeDate = businessData.getValidateEmailData().getCode();

			if (!codeInsertion.equals(codeDate))
				businessData.setError(messageAuth.ERROR_CODE_INCORRECT);
		}
	}

}
