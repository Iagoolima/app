package com.base.core.business.impl;

import com.base.domain.AuthUser;
import com.base.dto.AuthUser.LoginAuthUserDtoRequest;
import lombok.Data;

@Data
public class LoginBusinessData extends BusinessApplication<LoginBusinessData> {

	private AuthUser authUser = new AuthUser();

	public LoginBusinessData(LoginAuthUserDtoRequest dto) {
		authUser.setEmail(dto.getEmail().toLowerCase());
		authUser.setPassword(dto.getPassword());
	}

	private AuthUser authUserData;

}