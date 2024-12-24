package com.base.service;

import com.base.domain.Meal;
import com.base.domain.MealPlan;
import com.base.repository.MealPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealPlanService {

    @Autowired
    private MealPlanRepository repository;

    public void savePrimaryMealPlan(MealPlan mealPlan){
        Optional<MealPlan> optionalMealPlan = repository.findByProfileNutritionId(mealPlan.getProfileNutrition().getId());
        if(optionalMealPlan.isPresent()){
            repository.delete(optionalMealPlan.get());
        }
        repository.save(mealPlan);
    }

    public Meal findMeal(Integer idMeal, Integer idProfileNutrition){
        Optional<MealPlan> optionalMealPlan = repository.findByProfileNutritionId(idProfileNutrition);

        if(optionalMealPlan.isEmpty())
            return null;

        Meal meal = optionalMealPlan.get().getMeals().stream()
                .filter(m -> m.getIdMappingMeal().getId().equals(idMeal))
                .findFirst()
                .orElse(null);

        return meal;

    }

    public MealPlan findMealPlan(Integer idProfileNutrition){
        Optional<MealPlan> optionalMealPlan = repository.findByProfileNutritionId(idProfileNutrition);
        return optionalMealPlan.orElse(null);
    }

    public Boolean findCompletedMealPlan(Integer idProfileNutrition){
        Optional<MealPlan> optionalMealPlan = repository.findByProfileNutritionId(idProfileNutrition);
        return optionalMealPlan.map(MealPlan::getCompleted).orElse(null);
    }

    public void save(MealPlan mealPlan){
        repository.save(mealPlan);
    }

}
