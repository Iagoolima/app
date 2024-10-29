package com.base.core.business.impl;

import com.base.domain.AuthUser;
import com.base.domain.User;
import com.base.domain.ValidateEmail;
import com.base.dto.AuthUser.RegisterUserDtoRequest;
import lombok.Data;

import java.util.UUID;

@Data
public class RegisterBusinessData extends BusinessApplication<RegisterBusinessData> {

	private AuthUser authUser = new AuthUser();

	private User user = new User();

	public RegisterBusinessData(RegisterUserDtoRequest dto) {
		authUser.setId(UUID.randomUUID());
		authUser.setEmail(dto.getEmail().toLowerCase());
		authUser.setPassword(dto.getPassword());
		user.setEmail(dto.getEmail().toLowerCase());
		user.setName(dto.getName());
		user.setTelephone(dto.getTelephone());
	}

	ValidateEmail validateEmailData = new ValidateEmail();

}
