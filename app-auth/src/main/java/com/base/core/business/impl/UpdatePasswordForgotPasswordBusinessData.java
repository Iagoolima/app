package com.base.core.business.impl;

import com.base.domain.AuthUser;
import com.base.domain.ForgotPassword;
import com.base.domain.UpdatePasswordForgotPassword;
import com.base.dto.AuthUser.UpdatePasswordForgotPasswordDtoRequest;
import lombok.Data;

@Data
public class UpdatePasswordForgotPasswordBusinessData
		extends BusinessApplication<UpdatePasswordForgotPasswordBusinessData> {

	private UpdatePasswordForgotPassword updatePasswordForgotPassword = new UpdatePasswordForgotPassword();

	public UpdatePasswordForgotPasswordBusinessData(UpdatePasswordForgotPasswordDtoRequest dto) {
		updatePasswordForgotPassword.setTokenUpdate(dto.getToken());
		updatePasswordForgotPassword.setPassword(dto.getPassword());
	}

	private AuthUser authUserData = new AuthUser();

	private ForgotPassword forgotPasswordData = new ForgotPassword();

}
