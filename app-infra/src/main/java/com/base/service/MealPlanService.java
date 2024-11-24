package com.base.service;

import com.base.domain.MealPlan;
import com.base.repository.MealPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealPlanService {

    @Autowired
    private MealPlanRepository repository;

    public void save(MealPlan mealPlan){
        repository.save(mealPlan);
    }
}
