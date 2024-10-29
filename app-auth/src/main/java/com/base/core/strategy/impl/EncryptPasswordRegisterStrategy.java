package com.base.core.strategy.impl;

import com.base.core.business.impl.RegisterBusinessData;
import com.base.core.strategy.IStrategy;
import com.base.domain.AuthUser;
import com.base.utils.impl.EncryptBCript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EncryptPasswordRegisterStrategy implements IStrategy {

	@Autowired
	private EncryptBCript encryption;

	@Override
	public void execute() {

		RegisterBusinessData businessData = RegisterBusinessData.getStaticInstance(RegisterBusinessData.class);

		if (!businessData.isError()) {

			AuthUser authUser = businessData.getAuthUser();

			authUser.setPassword(encryption.encryptPassword(authUser.getPassword(), authUser.getId()));

		}

	}

}
