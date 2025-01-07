package com.base.utils;

import java.util.UUID;

public interface IEncryptBCrypt {

	String encryptPassword(String seed, UUID water);

	String getPasswordEncrypt(String seed, UUID water);

}
