package com.base.utils.impl;

import com.base.utils.IEncryptBCript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EncryptBCript implements IEncryptBCript {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Value("${salt.password}")
	private String soil;

	public String encryptPassword(String seed, UUID water) {
		return passwordEncoder.encode(soil + seed + water.toString());
	}

	public String getPasswordEncrypt(String seed, UUID water) {
		return soil + seed + water.toString();
	}

}
