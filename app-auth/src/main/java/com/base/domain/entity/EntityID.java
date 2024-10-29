package com.base.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class EntityID {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	private LocalDateTime insertionDate;

	@PrePersist
	protected void onCreate() {
		this.insertionDate = LocalDateTime.now();
	}

}
