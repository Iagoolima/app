package com.base.domain;

import com.base.domain.entity.EntityUUID;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class User extends EntityUUID {

	@Column(length = 100)
	private String name;

	private String telephone;

	@Column(length = 100)
	private String email;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_plano_nutricional", foreignKey = @ForeignKey(name = "fk_plano_nutricional"))
	private ProfileNutrition profileNutrition;

	@PrePersist
	protected void onCreate() {
		super.onCreate();
	}

}
