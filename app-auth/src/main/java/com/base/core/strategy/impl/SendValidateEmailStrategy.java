package com.base.core.strategy.impl;

import com.base.core.business.impl.BusinessApplication;
import com.base.core.business.impl.ValidateEmailBusinessData;
import com.base.core.facade.impl.AuthUserFacade;
import com.base.core.strategy.IStrategy;
import com.base.domain.BodyEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendValidateEmailStrategy implements IStrategy {

	@Autowired
	private AuthUserFacade facade;

	@Override
	public void execute() {

		ValidateEmailBusinessData businessData = BusinessApplication.getStaticInstance(ValidateEmailBusinessData.class);

		if (!businessData.isError()) {

			BodyEmail email = businessData.getBodyEmail();

			facade.sendEmail(email);

		}

	}

}
