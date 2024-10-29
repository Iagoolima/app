package com.base.dto.AuthUser;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class LoginAuthUserDtoRequest {

	@NotBlank(message = "O e-mail não pode estar em branco.")
	@NotNull(message = "O e-mail é obrigatório.")
	@Email(message = "O e-mail informado é inválido.")
	@Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres.")
	private String email;

	@NotBlank(message = "A senha não pode estar em branco.")
	@NotNull(message = "A senha é obrigatória.")
	@Size(min = 4, max = 100, message = "A senha deve ter entre 4 e 100 caracteres.")
	private String password;

}