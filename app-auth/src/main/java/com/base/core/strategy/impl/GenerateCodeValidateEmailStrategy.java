package com.base.core.strategy.impl;

import com.base.constants.NumberOfCodeGeneratorDigits;
import com.base.core.business.impl.ValidateEmailBusinessData;
import com.base.core.strategy.IStrategy;
import com.base.domain.ValidateEmail;
import com.base.utils.impl.GeneratedCodeAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenerateCodeValidateEmailStrategy implements IStrategy {

	@Autowired
	private NumberOfCodeGeneratorDigits numberOfCodeGeneratorDigits;

	@Autowired
	private GeneratedCodeAuth generatedCodeAuth;

	@Override
	public void execute() {

		ValidateEmailBusinessData businessData = ValidateEmailBusinessData
			.getStaticInstance(ValidateEmailBusinessData.class);

		if (!businessData.isError()) {

			ValidateEmail validateEmail = businessData.getValidateEmail();

			validateEmail.setCode(generatedCodeAuth.generatedCode(numberOfCodeGeneratorDigits.DIGITS_VALIDATE_EMAIL));

		}

	}

}
