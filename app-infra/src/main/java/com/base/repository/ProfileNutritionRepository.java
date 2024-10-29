package com.base.repository;

import com.base.domain.ProfileNutrition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileNutritionRepository extends JpaRepository<ProfileNutrition, Integer> {

}
