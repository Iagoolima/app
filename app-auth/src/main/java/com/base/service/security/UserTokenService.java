package com.base.service.security;

import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserTokenService {

	@Value("${jwt.chave-criptografia}")
	private String chaveCriptografia;

	@Autowired
	JwtServiceImpl jwtServiceImpl;

	public UUID getIdDoUsuarioDoTokenJWT(String token) {
		try {
			if (token.startsWith("Bearer ")) {
				token = token.substring(7);
			}
			JWTClaimsSet claims = jwtServiceImpl.getClaims(token);
			String uuid = claims.getStringClaim("userUuid");
			return UUID.fromString(uuid);
		}
		catch (Exception e) {
			throw new RuntimeException("erro ao descriptografar chave do usuario ", e);
		}
	}

}
