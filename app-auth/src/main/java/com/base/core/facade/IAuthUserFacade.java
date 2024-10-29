package com.base.core.facade;

import com.base.domain.*;

import java.util.UUID;

public interface IAuthUserFacade {

	AuthUser searchDataAuthUser(String email);

	boolean emailAvailabilityChecker(String email);

	void registerAuthUser(AuthUser authUser);

	User registerUser(User user);

	AuthUser findAuthUser(UUID id);

	void saveAuthUser(AuthUser authUser);

	void sendEmail(BodyEmail email);

	void saveValidateEmail(ValidateEmail validateEmail);

	ValidateEmail checkValidValidatedEmail(String email);

	ValidateEmail findValidateEmail(String email);

	void updateStateValidateEmail(ValidateEmail validateEmail);

	void deleteValidateEmail(int id);

	void saveForgotPassword(ForgotPassword forgotPassword);

	ForgotPassword findForgotPassword(UUID tokenUpdate);

	void updateStateForgotPassword(ForgotPassword forgotPasswordData);

	void deleteForgotPassword(int id);

}
