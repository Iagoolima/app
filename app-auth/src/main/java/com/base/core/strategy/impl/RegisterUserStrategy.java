package com.base.core.strategy.impl;

import com.base.core.business.impl.RegisterBusinessData;
import com.base.core.business.impl.BusinessApplication;
import com.base.core.facade.impl.AuthUserFacade;
import com.base.core.strategy.IStrategy;
import com.base.domain.AuthUser;
import com.base.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserStrategy implements IStrategy {

	@Autowired
	private AuthUserFacade facade;

	@Override
	public void execute() {
		RegisterBusinessData businessData = BusinessApplication.getStaticInstance(RegisterBusinessData.class);

		if (!businessData.isError()) {
			User user = businessData.getUser();
			AuthUser authUser = businessData.getAuthUser();

			User userData = facade.registerUser(user);

			authUser.setUser(userData);

			businessData.setAuthUser(authUser);
		}
	}

}
