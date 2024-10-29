package com.base.dto.AuthUser;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CheckCodeForgotPasswordDtoRequest {

	@NotBlank(message = "O token não pode estar em branco.")
	@NotNull(message = "O token é obrigatório.")
	@Size(max = 100, message = "O token deve ter no máximo 100 caracteres.")
	private String token;

	@NotBlank(message = "O código de validação não pode estar em branco.")
	@NotNull(message = "O código de validação é obrigatório.")
	@Size(min = 6, max = 6, message = "O código de validação deve ter exatamente 6 dígitos.")
	private String code;

}