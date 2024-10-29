package com.base.core.business.impl;

import com.base.domain.CheckCodeForgotPassword;
import com.base.domain.ForgotPassword;
import com.base.dto.AuthUser.CheckCodeForgotPasswordDtoRequest;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CheckCodeForgotPasswordBusinessData extends BusinessApplication<CheckCodeForgotPasswordBusinessData> {

	private CheckCodeForgotPassword checkCodeForgotPassword = new CheckCodeForgotPassword();

	public CheckCodeForgotPasswordBusinessData(CheckCodeForgotPasswordDtoRequest dto) {
		checkCodeForgotPassword.setToken(dto.getToken());
		checkCodeForgotPassword.setCode(dto.getCode());
		checkCodeForgotPassword.setInsertionTime(LocalDateTime.now());
	}

	private ForgotPassword forgotPasswordData = new ForgotPassword();

}
