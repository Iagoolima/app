package com.base.utils.impl;

import com.base.utils.IGeneratedCodeAuth;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GeneratedCodeAuth implements IGeneratedCodeAuth {

	private static final String caracteres = "123456789ABCDEFGHIJKLMNPQRSTUVWXYZ";

	@Override
	public String generatedCode(int length) {

		Random random = new Random();
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(caracteres.length());
			sb.append(caracteres.charAt(index));
		}

		return sb.toString();

	}

}
