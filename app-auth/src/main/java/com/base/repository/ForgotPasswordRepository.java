package com.base.repository;

import com.base.domain.ForgotPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ForgotPasswordRepository extends JpaRepository<ForgotPassword, Integer> {

	Optional<ForgotPassword> findByEmail(String email);

	Optional<ForgotPassword> findByTokenUpdate(UUID tokenUpdate);

}
