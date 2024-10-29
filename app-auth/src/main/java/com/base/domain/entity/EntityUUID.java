package com.base.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class EntityUUID {

	@Id
	private UUID id;

	private LocalDateTime insertionDate;

	@PrePersist
	protected void onCreate() {
		if (this.id == null) {
			this.id = UUID.randomUUID();
		}
		this.insertionDate = LocalDateTime.now();
	}

}
