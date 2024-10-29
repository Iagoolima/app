package com.base.domain;

import com.base.domain.entity.EntityID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "esqueceu_senha")
public class ForgotPassword extends EntityID {

	@Column(unique = true, length = 100)
	private String email;

	private UUID tokenUpdate;

	private UUID idAuthUser;

	@Column(length = 6)
	private String code;

	private boolean validated = false;

	private LocalDateTime recordedTime;

	@PrePersist
	protected void onCreate() {
		this.recordedTime = LocalDateTime.now();
		super.onCreate();
	}

}
