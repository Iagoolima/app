package com.base.service;

import com.base.domain.MealPlan;
import com.base.repository.MealPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MealPlanService {

    @Autowired
    private MealPlanRepository repository;

    public void save(MealPlan mealPlan){
        Optional<MealPlan> optionalMealPlan = repository.findByProfileNutritionId(mealPlan.getProfileNutrition().getId());
        if(optionalMealPlan.isPresent()){
            repository.delete(optionalMealPlan.get());
        }
        repository.save(mealPlan);
    }
}
