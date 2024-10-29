package com.base.core.strategy.impl;

import com.base.constants.MessageAuth;
import com.base.core.business.impl.BusinessApplication;
import com.base.core.business.impl.LoginBusinessData;
import com.base.core.facade.impl.AuthUserFacade;
import com.base.core.strategy.IStrategy;
import com.base.domain.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchDataAuthUserStrategy implements IStrategy {

	@Autowired
	private MessageAuth messageAuth;

	@Autowired
	private AuthUserFacade facade;

	@Override
	public void execute() {
		LoginBusinessData loginBusinessData = BusinessApplication.getStaticInstance(LoginBusinessData.class);

		if (!loginBusinessData.isError()) {

			AuthUser authUser = loginBusinessData.getAuthUser();

			AuthUser authUserData = facade.searchDataAuthUser(authUser.getEmail());
			if (authUserData == null)
				loginBusinessData.setError(messageAuth.ERROR_USER_NOT_FOUND);

			loginBusinessData.setAuthUserData(authUserData);
		}
	}

}
