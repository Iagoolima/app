package com.base.repository;

import com.base.domain.Focus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface FocusRepository extends JpaRepository<Focus, Integer> {
}
