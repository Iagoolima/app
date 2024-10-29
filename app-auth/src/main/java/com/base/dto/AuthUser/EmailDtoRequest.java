package com.base.dto.AuthUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmailDtoRequest {

	@NotBlank(message = "O e-mail não pode estar em branco.")
	@NotNull(message = "O e-mail é obrigatório.")
	@Email(message = "O e-mail informado é inválido.")
	@Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres.")
	private String email;

}