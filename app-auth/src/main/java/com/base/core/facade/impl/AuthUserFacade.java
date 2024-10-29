package com.base.core.facade.impl;

import com.base.core.facade.IAuthUserFacade;
import com.base.service.authUser.impl.AuthUserService;
import com.base.service.authUser.impl.EmailService;
import com.base.service.authUser.impl.ForgotPasswordService;
import com.base.service.authUser.impl.ValidateEmailService;
import com.base.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AuthUserFacade implements IAuthUserFacade {

	@Autowired
	private AuthUserService authUserService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private ValidateEmailService validateEmailService;

	@Autowired
	private ForgotPasswordService forgotPasswordService;

	public AuthUser searchDataAuthUser(String email) {
		return authUserService.searchDataAuthUser(email);
	}

	public boolean emailAvailabilityChecker(String email) {
		return authUserService.emailAvailabilityChecker(email);
	}

	public void registerAuthUser(AuthUser authUser) {
		authUserService.registerAuthUser(authUser);
	}

	public User registerUser(User user) {
		return authUserService.registerUser(user);
	}

	public AuthUser findAuthUser(UUID id) {
		return authUserService.findAuthUser(id);
	}

	public void saveAuthUser(AuthUser authUser) {
		authUserService.saveAuthUser(authUser);
	}

	public void sendEmail(BodyEmail email) {
		emailService.sendEmail(email);
	}

	public void saveValidateEmail(ValidateEmail validateEmail) {
		validateEmailService.saveValidateEmail(validateEmail);
	}

	public ValidateEmail checkValidValidatedEmail(String email) {
		return validateEmailService.checkValidValidatedEmail(email);
	}

	public ValidateEmail findValidateEmail(String email) {
		return validateEmailService.findValidateEmail(email);
	}

	public void updateStateValidateEmail(ValidateEmail validateEmail) {
		validateEmailService.updateStateValidateEmail(validateEmail);
	}

	public void deleteValidateEmail(int id) {
		validateEmailService.deleteValidateEmail(id);
	}

	public void saveForgotPassword(ForgotPassword forgotPassword) {
		forgotPasswordService.saveForgotPassword(forgotPassword);
	}

	public ForgotPassword findForgotPassword(UUID tokenUpdate) {
		return forgotPasswordService.findForgotPassword(tokenUpdate);
	}

	public void updateStateForgotPassword(ForgotPassword forgotPasswordData) {
		forgotPasswordService.updateStateForgotPassword(forgotPasswordData);
	}

	public void deleteForgotPassword(int id) {
		forgotPasswordService.deleteForgotPassword(id);
	}

}