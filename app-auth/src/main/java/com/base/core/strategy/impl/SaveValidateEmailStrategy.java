package com.base.core.strategy.impl;

import com.base.core.business.impl.ValidateEmailBusinessData;
import com.base.core.facade.impl.AuthUserFacade;
import com.base.core.strategy.IStrategy;
import com.base.domain.ValidateEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveValidateEmailStrategy implements IStrategy {

	@Autowired
	private AuthUserFacade facade;

	@Override
	public void execute() {

		ValidateEmailBusinessData businessData = ValidateEmailBusinessData
			.getStaticInstance(ValidateEmailBusinessData.class);

		if (!businessData.isError()) {

			ValidateEmail validateEmail = businessData.getValidateEmail();

			facade.saveValidateEmail(validateEmail);

		}

	}

}
