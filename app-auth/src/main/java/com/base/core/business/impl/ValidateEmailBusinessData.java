package com.base.core.business.impl;

import com.base.domain.BodyEmail;
import com.base.domain.ValidateEmail;
import com.base.dto.AuthUser.ValidateEmailDtoRequest;
import lombok.Data;

@Data
public class ValidateEmailBusinessData extends BusinessApplication<ValidateEmailBusinessData> {

	private ValidateEmail validateEmail = new ValidateEmail();

	public ValidateEmailBusinessData(ValidateEmailDtoRequest dto) {
		validateEmail.setEmail(dto.getEmail().toLowerCase());
	}

	private BodyEmail bodyEmail = new BodyEmail();

}
