package com.base.dto.AuthUser;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegisterUserDtoRequest {

	@NotBlank(message = "O e-mail não pode estar em branco.")
	@NotNull(message = "O e-mail é obrigatório.")
	@Email(message = "O e-mail informado é inválido.")
	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "O formato do e-mail informado é inválido.")
	@Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres.")
	private String email;

	@NotBlank(message = "A senha não pode estar em branco.")
	@NotNull(message = "A senha é obrigatória.")
	@Size(min = 4, max = 100, message = "A senha deve ter entre 4 e 100 caracteres.")
	private String password;

	@NotBlank(message = "O nome não pode estar em branco.")
	@NotNull(message = "O nome é obrigatório.")
	@Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
	private String name;

	@NotBlank(message = "O telefone não pode estar em branco.")
	@NotNull(message = "O telefone é obrigatório.")
	@Size(min = 11, max = 11, message = "O telefone deve ter exatamente 11 caracteres.")
	@Pattern(regexp = "\\d{11}", message = "O telefone deve conter apenas números.")
	private String telephone;

}