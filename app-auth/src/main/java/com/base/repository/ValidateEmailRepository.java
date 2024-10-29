package com.base.repository;

import com.base.domain.ValidateEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ValidateEmailRepository extends JpaRepository<ValidateEmail, Integer> {

	Optional<ValidateEmail> findByEmail(String email);

}
