package com.base.utils;

import java.util.UUID;

public interface IEncryptBCript {

	String encryptPassword(String seed, UUID water);

	String getPasswordEncrypt(String seed, UUID water);

}
