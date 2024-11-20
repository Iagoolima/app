package com.base.domain;

import com.base.domain.entity.EntityID;
import lombok.Data;

import java.util.List;

@Data
public class MealPlan extends EntityID {

    private int idProfileNutrition;
    private List<Meal> meals;
    private int totalCalories;

}
