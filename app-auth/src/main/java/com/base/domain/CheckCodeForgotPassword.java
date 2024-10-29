package com.base.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CheckCodeForgotPassword {

	private String token;

	private String code;

	private LocalDateTime insertionTime;

}
