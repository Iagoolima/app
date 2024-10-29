package com.base.dto.AuthUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ValidateEmailDtoRequest {

	@NotBlank(message = "O email não pode estar em branco.")
	@NotNull(message = "O email é obrigatório.")
	@Email(message = "Email inválido.")
	@Size(max = 100, message = "O email deve ter no máximo 100 caracteres.")
	private String email;

}