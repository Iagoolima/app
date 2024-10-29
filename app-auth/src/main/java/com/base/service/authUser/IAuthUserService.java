package com.base.service.authUser;

import com.base.domain.AuthUser;
import com.base.domain.User;

import java.util.UUID;

public interface IAuthUserService {

	AuthUser searchDataAuthUser(String email);

	boolean emailAvailabilityChecker(String email);

	void registerAuthUser(AuthUser authUser);

	User registerUser(User user);

	AuthUser findAuthUser(UUID id);

	void saveAuthUser(AuthUser authUser);

}
