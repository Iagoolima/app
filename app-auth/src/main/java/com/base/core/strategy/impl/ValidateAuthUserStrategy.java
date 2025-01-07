package com.base.core.strategy.impl;

import com.base.constants.MessageAuth;
import com.base.core.business.impl.BusinessApplication;
import com.base.core.business.impl.LoginBusinessData;
import com.base.core.strategy.IStrategy;
import com.base.domain.AuthUser;
import com.base.service.security.JwtServiceImpl;
import com.base.utils.impl.EncryptBCrypt;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ValidateAuthUserStrategy implements IStrategy {

	@Autowired
	private EncryptBCrypt encryption;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private JwtServiceImpl jwtService;

	@Autowired
	private MessageAuth messageAuth;

	@SneakyThrows
	@Override
	public void execute() {

		LoginBusinessData businessData = BusinessApplication.getStaticInstance(LoginBusinessData.class);

		if (!businessData.isError()) {
			AuthUser authUser = businessData.getAuthUser();
			AuthUser authUserData = businessData.getAuthUserData();

			authUser.setPassword(encryption.getPasswordEncrypt(authUser.getPassword(), authUserData.getId()));

			if (passwordEncoder.matches(authUser.getPassword(), authUserData.getPassword())) {
				businessData.getTokenResponse().setAcessToken(jwtService.generateToken(authUserData));
				businessData.getTokenResponse().setRefreshToken(jwtService.generateRefreshToken(authUserData));
			}
			else {
				businessData.setError(messageAuth.ERROR_PASSWORD_INCORRECT);
			}

		}
	}

}
