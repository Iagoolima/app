package com.base.constants;

import org.springframework.stereotype.Component;

@Component
public class MessageAuth {

	// Mensagens de erro
	public final String ERROR_USER_NOT_FOUND = "Usuário não encontrado!";

	public final String ERROR_EMAIL_ALREADY_EXISTS = "E-mail já existe!";

	public final String ERROR_EMAIL_NOT_VALIDATED = "E-mail não foi validado!";

	public final String ERROR_USER_NOT_EXIST = "E-mail não encontrado para validação!";

	public final String ERROR_PASSWORD_INCORRECT = "Senha incorreta!";

	public final String ERROR_TIMER_EXCEEDED = "Tempo excedido!";

	public final String ERROR_CODE_INCORRECT = "Código incorreto!";

	public final String ERROR_TOKEN_UPDATE_NOT_EXISTS = "Token de atualização de senha não encontrado!";

	public final String ERROR_TOKEN_UPDATE_NOT_VALIDATED = "Token de atualização de senha encontrado, mas não está validado.";

	public final String ERROR_EMAIL_VALIDATED = "E-mail já foi validado!";

	public final String ERROR_EMAIL_NOT_SEND = "Erro ao enviar E-mail";

	// Mensagens informativas
	public final String SEND_VALIDATE_EMAIL_TITLE = "Validação de E-mail";

	public final String SEND_VALIDATE_EMAIL_MESSAGE = "Código de validação do e-mail: {0}";

	public final String SEND_REPLACE_PASSWORD_TITLE = "Trocar Senha";

	public final String SEND_REPLACE_PASSWORD_MESSAGE = "Olá, código de validação para trocar a senha: {0}";

}