package com.base.domain;

import com.base.domain.entity.EntityUUID;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "autenticacao")
@Entity
public class AuthUser extends EntityUUID {

	@Column(length = 100)
	private String email;

	private String password;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_autenticacao_usuario"))
	private User user;

	@PrePersist
	protected void onCreate() {
		super.onCreate();
	}

}
