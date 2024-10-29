package com.base.core.business.impl;

import com.base.domain.AuthUser;
import com.base.domain.BodyEmail;
import com.base.domain.ForgotPassword;
import com.base.dto.AuthUser.EmailDtoRequest;
import lombok.Data;

import java.util.UUID;

@Data
public class ForgotPasswordBusinessData extends BusinessApplication<ForgotPasswordBusinessData> {

	private ForgotPassword forgotPassword = new ForgotPassword();

	public ForgotPasswordBusinessData(EmailDtoRequest dto) {
		forgotPassword.setEmail(dto.getEmail().toLowerCase());
		forgotPassword.setTokenUpdate(UUID.randomUUID());
	}

	private AuthUser authUserData = new AuthUser();

	private BodyEmail bodyEmail = new BodyEmail();

}
