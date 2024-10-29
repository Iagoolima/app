package com.base.dto.AuthUser;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdatePasswordForgotPasswordDtoRequest {

	@NotBlank(message = "O token não pode estar em branco.")
	@NotNull(message = "O token é obrigatório.")
	private String token;

	@NotBlank(message = "A nova senha não pode estar em branco.")
	@NotNull(message = "A nova senha é obrigatória.")
	@Size(min = 4, max = 100, message = "A senha deve ter entre 4 e 100 caracteres.")
	private String password;

}