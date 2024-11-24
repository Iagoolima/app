package com.base.mapper.impl;

import com.base.domain.ItemMeal;
import com.base.domain.Meal;
import com.base.domain.MealPlan;
import com.base.domain.ProfileNutrition;
import com.base.dto.moduleIA.ItemMealDto;
import com.base.dto.moduleIA.MealDto;
import com.base.dto.moduleIA.MealPlanDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MealPlanMapper {

    public MealPlan toEntity(MealPlanDto dto, ProfileNutrition profileNutrition){

        MealPlan mealPlanEntity = new MealPlan();
        mealPlanEntity.setProfileNutrition(profileNutrition);
        mealPlanEntity.setTotalCalories(dto.getTotalCalories());

        List<Meal> mealListEntity = new ArrayList<>();
        for(MealDto mealDto : dto.getMeals()){

            Meal mealEntity = new Meal();
            mealEntity.setMealPlan(mealPlanEntity);
            mealEntity.setMealName(mealDto.getMealName());

            List<ItemMeal> itemMealListEntity = new ArrayList<>();
            for(ItemMealDto itemMealDto : mealDto.getItems()){
                ItemMeal itemMeal = new ItemMeal();
                itemMeal.setCalories(itemMealDto.getCalories());
                itemMeal.setDetails(itemMealDto.getDetails());
                itemMeal.setFood(itemMealDto.getFood());
                itemMeal.setQuantity(itemMealDto.getQuantity());
                itemMeal.setMeal(mealEntity);
                itemMealListEntity.add(itemMeal);
            }

            mealEntity.setItems(itemMealListEntity);
            mealListEntity.add(mealEntity);

        }
        mealPlanEntity.setMeals(mealListEntity);

        return mealPlanEntity;
    }
}
