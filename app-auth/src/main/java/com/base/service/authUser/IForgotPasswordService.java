package com.base.service.authUser;

import com.base.domain.ForgotPassword;

import java.util.UUID;

public interface IForgotPasswordService {

	void saveForgotPassword(ForgotPassword forgotPassword);

	ForgotPassword findForgotPassword(UUID tokenUpdate);

	void updateStateForgotPassword(ForgotPassword forgotPasswordData);

	void deleteForgotPassword(int id);

}
