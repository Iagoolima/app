package com.base.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CheckCodeValidateEmail {

	private String email;

	private String code;

	private LocalDateTime dateTime;

}
