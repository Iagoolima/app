package com.base.controller.impl;

import com.base.controller.IAuthUserController;
import com.base.core.business.impl.*;
import com.base.core.navigator.impl.AuthUserNavigation;
import com.base.dto.AuthUser.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@Validated
public class AuthUserController implements IAuthUserController {

	@Autowired
	private AuthUserNavigation authUserNavigation;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid LoginAuthUserDtoRequest dto) {
		LoginBusinessData loginBusinessData = handleBusinessOperation(new LoginBusinessData(dto),
				authUserNavigation::loginNavigation);
		return loginBusinessData.isError() ? ResponseEntity.badRequest().body(loginBusinessData.getMessageError())
				: ResponseEntity.ok(loginBusinessData.getTokenResponse());
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody @Valid RegisterUserDtoRequest dto) {
		RegisterBusinessData registerBusinessData = handleBusinessOperation(new RegisterBusinessData(dto),
				authUserNavigation::registerNavigation);
		return registerBusinessData.isError() ? ResponseEntity.badRequest().body(registerBusinessData.getMessageError())
				: ResponseEntity.ok(registerBusinessData.getTokenResponse());
	}

	@PostMapping("/check-email")
	public ResponseEntity<?> validateEmail(@RequestBody @Valid ValidateEmailDtoRequest dto) {
		ValidateEmailBusinessData validateEmailBusinessData = handleBusinessOperation(
				new ValidateEmailBusinessData(dto), authUserNavigation::validateEmailNavigation);
		return validateEmailBusinessData.isError()
				? ResponseEntity.badRequest().body(validateEmailBusinessData.getMessageError())
				: ResponseEntity.ok().build();
	}

	@PostMapping("/valid-code-email")
	public ResponseEntity<?> checkCodeValidateEmail(@RequestBody @Valid CheckCodeValidateEmailDtoRequest dto) {
		CheckCodeValidateEmailBusinessData checkCodeValidateEmailBusinessData = handleBusinessOperation(
				new CheckCodeValidateEmailBusinessData(dto), authUserNavigation::checkCodeValidateEmailNavigation);
		return checkCodeValidateEmailBusinessData.isError()
				? ResponseEntity.badRequest().body(checkCodeValidateEmailBusinessData.getMessageError())
				: ResponseEntity.ok().build();
	}

	@PostMapping("/forgot-password")
	public ResponseEntity<?> forgotPassword(@RequestBody @Valid EmailDtoRequest dto) {
		ForgotPasswordBusinessData forgotPasswordBusinessData = handleBusinessOperation(
				new ForgotPasswordBusinessData(dto), authUserNavigation::sendForgotPasswordNavigation);
		return forgotPasswordBusinessData.isError()
				? ResponseEntity.badRequest().body(forgotPasswordBusinessData.getMessageError())
				: ResponseEntity.ok(forgotPasswordBusinessData.getTokenResponse());
	}

	@PostMapping("/check-code-forgot-password")
	public ResponseEntity<?> checkCodeForgotPassword(@RequestBody @Valid CheckCodeForgotPasswordDtoRequest dto) {
		CheckCodeForgotPasswordBusinessData checkCodeForgotPasswordBusinessData = handleBusinessOperation(
				new CheckCodeForgotPasswordBusinessData(dto), authUserNavigation::checkCodeForgotPasswordNavigation);
		return checkCodeForgotPasswordBusinessData.isError()
				? ResponseEntity.badRequest().body(checkCodeForgotPasswordBusinessData.getMessageError())
				: ResponseEntity.ok().build();
	}

	@PostMapping("/update-forgot-password")
	public ResponseEntity<?> updatePasswordForgotPassword(
			@RequestBody @Valid UpdatePasswordForgotPasswordDtoRequest dto) {
		UpdatePasswordForgotPasswordBusinessData updatePasswordForgotPasswordBusinessData = handleBusinessOperation(
				new UpdatePasswordForgotPasswordBusinessData(dto), authUserNavigation::updatePasswordForgotPasswordNavigation);
		return updatePasswordForgotPasswordBusinessData.isError()
				? ResponseEntity.badRequest().body(updatePasswordForgotPasswordBusinessData.getMessageError())
				: ResponseEntity.ok().build();
	}

	private <T extends BusinessApplication<?>> T handleBusinessOperation(T businessData, Runnable navigation) {
		BusinessApplication.setStaticInstance(businessData.getClass(), businessData);
		navigation.run();
		return (T) BusinessApplication.getStaticInstance(businessData.getClass());
	}

}