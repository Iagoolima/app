package com.base.dto.AuthUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CheckCodeValidateEmailDtoRequest {

	@NotBlank(message = "O e-mail não pode estar em branco.")
	@NotNull(message = "O e-mail é obrigatório.")
	@Email(message = "E-mail inválido!")
	@Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres.")
	private String email;

	@NotBlank(message = "O código de verificação não pode estar em branco.")
	@NotNull(message = "O código de verificação é obrigatório.")
	@Size(min = 4, max = 4, message = "O código de verificação deve ter exatamente 4 caracteres.")
	private String code;

}