package com.base.core.strategy.impl;

import com.base.core.business.impl.RegisterBusinessData;
import com.base.core.facade.impl.AuthUserFacade;
import com.base.core.strategy.IStrategy;
import com.base.domain.ValidateEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteValidateEmailStrategy implements IStrategy {

	@Autowired
	private AuthUserFacade facade;

	@Override
	public void execute() {

		RegisterBusinessData businessData = RegisterBusinessData.getStaticInstance(RegisterBusinessData.class);

		if (!businessData.isError()) {

			ValidateEmail validateEmail = businessData.getValidateEmailData();

			facade.deleteValidateEmail(validateEmail.getId());

		}

	}

}
