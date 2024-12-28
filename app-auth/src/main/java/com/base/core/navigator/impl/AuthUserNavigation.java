package com.base.core.navigator.impl;

import com.base.core.navigator.IAuthUserNavigation;
import com.base.core.navigator.NavigationApplication;
import com.base.core.strategy.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthUserNavigation extends NavigationApplication implements IAuthUserNavigation {

	@Autowired
	private CheckerCodeForgotPasswordStrategy checkerCodeForgotPasswordStrategy;

	@Autowired
	private CheckerCodeValidateEmailStrategy checkerCodeValidateEmailStrategy;

	@Autowired
	private CheckerEmailExistsForgotPasswordStrategy checkerEmailExistsForgotPasswordStrategy;

	@Autowired
	private CheckerTimerForgotPasswordStrategy checkerTimerForgotPasswordStrategy;

	@Autowired
	private CheckerTimerValidateEmailStrategy checkerTimerValidateEmailStrategy;

	@Autowired
	private CheckerTokenUpdateForgotPasswordStrategy checkerTokenUpdateForgotPasswordStrategy;

	@Autowired
	private CheckerValidValidateEmailStrategy checkerValidValidateEmailStrategy;

	@Autowired
	private DeleteForgotPasswordStrategy deleteForgotPasswordStrategy;

	@Autowired
	private DeleteValidateEmailStrategy deleteValidateEmailStrategy;

	@Autowired
	private EmailAvailabilityCheckerStrategy emailAvailabilityCheckerStrategy;

	@Autowired
	private EncryptPasswordforgotPasswordStrategy encryptPasswordforgotPasswordStrategy;

	@Autowired
	private EncryptPasswordRegisterStrategy encryptPasswordRegisterStrategy;

	@Autowired
	private FindAuthUserForgotPasswordStartegy findAuthUserForgotPasswordStartegy;

	@Autowired
	private FindCheckerValidateEmailStrategy findCheckerValidateEmailStrategy;

	@Autowired
	private FindForgotPasswordStrategy findForgotPasswordStrategy;

	@Autowired
	private GenerateBodyEmailValidateEmailStrategy generateBodyEmailValidateEmailStrategy;

	@Autowired
	private GenerateBodyForgotPasswordStrategy generateBodyForgotPasswordStrategy;

	@Autowired
	private GenerateCodeValidateEmailStrategy generateCodeValidateEmailStrategy;

	@Autowired
	private PrepareForgotPasswordStrategy prepareForgotPasswordStrategy;

	@Autowired
	private RegisterAuthUserStrategy registerAuthUserStrategy;

	@Autowired
	private RegisterUserStrategy registerUserStrategy;

	@Autowired
	private SaveForgotPasswordStrategy saveForgotPasswordStrategy;

	@Autowired
	private SaveValidateEmailStrategy saveValidateEmailStrategy;

	@Autowired
	private SearchDataAuthUserStrategy searchDataAuthUserStrategy;

	@Autowired
	private SendEmailForgotPasswordStrategy sendEmailForgotPasswordStrategy;

	@Autowired
	private SendValidateEmailStrategy sendValidateEmailStrategy;

	@Autowired
	private UpdatePasswordForgotPasswordStrategy updatePasswordForgotPasswordStrategy;

	@Autowired
	private UpdateStateForgotPassowordStrategy updateStateForgotPassowordStrategy;

	@Autowired
	private UpdateStateValidateEmailStrategy updateStateValidateEmailStrategy;

	@Autowired
	private ValidateAuthUserStrategy validateAuthUserStrategy;

	@Autowired
	private ValidateEmailAvailabilityCheckerStrategy validateEmailAvailabilityCheckerStrategy;

	@Autowired
	private GeneratedAcessTokenStrategy generatedAcessTokenStrategy;

	public void checkCodeForgotPasswordNavigation() {
		navigatorExecute(checkerTokenUpdateForgotPasswordStrategy, checkerTimerForgotPasswordStrategy,
				checkerCodeForgotPasswordStrategy, updateStateForgotPassowordStrategy);
	}

	public void checkCodeValidateEmailNavigation() {
		navigatorExecute(findCheckerValidateEmailStrategy, checkerTimerValidateEmailStrategy,
				checkerCodeValidateEmailStrategy, updateStateValidateEmailStrategy);
	}

	public void loginNavigation() {
		navigatorExecute(searchDataAuthUserStrategy, validateAuthUserStrategy);
	}

	public void registerNavigation() {
		navigatorExecute(emailAvailabilityCheckerStrategy, checkerValidValidateEmailStrategy, registerUserStrategy,
				encryptPasswordRegisterStrategy, registerAuthUserStrategy, deleteValidateEmailStrategy);
	}

	public void sendForgotPasswordNavigation() {
		navigatorExecute(checkerEmailExistsForgotPasswordStrategy, prepareForgotPasswordStrategy,
				generateBodyForgotPasswordStrategy, sendEmailForgotPasswordStrategy, saveForgotPasswordStrategy);
	}

	public void updatePasswordForgotPasswordNavigation() {
		navigatorExecute(findForgotPasswordStrategy, findAuthUserForgotPasswordStartegy,
				encryptPasswordforgotPasswordStrategy, updatePasswordForgotPasswordStrategy,
				deleteForgotPasswordStrategy);
	}

	public void validateEmailNavigation() {
		navigatorExecute(validateEmailAvailabilityCheckerStrategy, generateCodeValidateEmailStrategy,
				generateBodyEmailValidateEmailStrategy, sendValidateEmailStrategy, saveValidateEmailStrategy);
	}

	public void generatedAcessToken() {
		navigatorExecute(generatedAcessTokenStrategy);
	}

}