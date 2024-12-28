package com.base.dto.AuthUser;

import lombok.Data;

@Data
public class TokenAuthUserDtoResponse {

	private String acessToken;

	private String refreshToken;

}
