package com.base.repository;

import com.base.domain.MappingMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingMealRepository extends JpaRepository<MappingMeal, Integer> {
}
