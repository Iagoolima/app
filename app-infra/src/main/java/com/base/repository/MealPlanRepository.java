package com.base.repository;

import com.base.domain.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MealPlanRepository extends JpaRepository<MealPlan, Integer> {

    Optional<MealPlan> findByProfileNutritionId(Integer idProfileNutrition);

}
