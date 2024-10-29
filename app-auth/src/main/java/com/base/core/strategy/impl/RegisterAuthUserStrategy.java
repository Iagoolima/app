package com.base.core.strategy.impl;

import com.base.core.business.impl.BusinessApplication;
import com.base.core.business.impl.RegisterBusinessData;
import com.base.core.facade.impl.AuthUserFacade;
import com.base.core.strategy.IStrategy;
import com.base.domain.AuthUser;
import com.base.service.security.JwtServiceImpl;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterAuthUserStrategy implements IStrategy {

	@Autowired
	private AuthUserFacade facade;

	@Autowired
	private JwtServiceImpl jwtService;

	@SneakyThrows
	@Override
	public void execute() {

		RegisterBusinessData businessData = BusinessApplication.getStaticInstance(RegisterBusinessData.class);

		if (!businessData.isError()) {

			AuthUser authUser = businessData.getAuthUser();

			facade.registerAuthUser(authUser);

			businessData.getTokenResponse().setToken(jwtService.generateToken(authUser));

		}
	}

}
