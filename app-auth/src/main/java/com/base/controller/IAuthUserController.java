package com.base.controller;

import com.base.dto.AuthUser.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAuthUserController {

	ResponseEntity login(@RequestBody @Valid LoginAuthUserDtoRequest dto);

	ResponseEntity register(@RequestBody @Valid RegisterUserDtoRequest dto);

	ResponseEntity validateEmail(@RequestBody @Valid ValidateEmailDtoRequest dto);

	ResponseEntity checkCodeValidateEmail(@RequestBody @Valid CheckCodeValidateEmailDtoRequest dto);

	ResponseEntity forgotPassword(@RequestBody @Valid EmailDtoRequest dto);

	ResponseEntity checkCodeForgotPassword(@RequestBody @Valid CheckCodeForgotPasswordDtoRequest dto);

	ResponseEntity updatePasswordForgotPassword(@RequestBody @Valid UpdatePasswordForgotPasswordDtoRequest dto);

}
