package com.base.domain;

import com.base.domain.entity.EntityID;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "validacao_email")
public class ValidateEmail extends EntityID {

	@Column(unique = true, length = 100)
	private String email;

	@Column(length = 4)
	private String code;

	private boolean validated = false;

	private LocalDateTime recordedTime;

	@PrePersist
	protected void onCreate() {
		this.recordedTime = LocalDateTime.now();
		super.onCreate();
	}

}
