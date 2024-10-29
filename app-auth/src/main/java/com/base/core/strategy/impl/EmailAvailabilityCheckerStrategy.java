package com.base.core.strategy.impl;

import com.base.constants.MessageAuth;
import com.base.core.business.impl.RegisterBusinessData;
import com.base.core.business.impl.BusinessApplication;
import com.base.core.facade.impl.AuthUserFacade;
import com.base.core.strategy.IStrategy;
import com.base.domain.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailAvailabilityCheckerStrategy implements IStrategy {

	@Autowired
	private MessageAuth messageAuth;

	@Autowired
	private AuthUserFacade facade;

	@Override
	public void execute() {

		RegisterBusinessData businessData = BusinessApplication.getStaticInstance(RegisterBusinessData.class);

		if (!businessData.isError()) {

			AuthUser authUser = businessData.getAuthUser();

			boolean userExists = facade.emailAvailabilityChecker(authUser.getEmail());

			if (userExists)
				businessData.setError(messageAuth.ERROR_EMAIL_ALREADY_EXISTS);

		}

	}

}
