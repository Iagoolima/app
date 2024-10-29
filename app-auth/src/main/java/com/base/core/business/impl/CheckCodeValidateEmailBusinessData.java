package com.base.core.business.impl;

import com.base.domain.CheckCodeValidateEmail;
import com.base.domain.ValidateEmail;
import com.base.dto.AuthUser.CheckCodeValidateEmailDtoRequest;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CheckCodeValidateEmailBusinessData extends BusinessApplication<CheckCodeValidateEmailBusinessData> {

	private CheckCodeValidateEmail checkCodeValidateEmail = new CheckCodeValidateEmail();

	public CheckCodeValidateEmailBusinessData(CheckCodeValidateEmailDtoRequest dto) {
		checkCodeValidateEmail.setEmail(dto.getEmail().toLowerCase());
		checkCodeValidateEmail.setCode(dto.getCode());
		checkCodeValidateEmail.setDateTime(LocalDateTime.now());
	}

	private ValidateEmail validateEmailData = new ValidateEmail();

}
