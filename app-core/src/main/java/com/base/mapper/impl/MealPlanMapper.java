package com.base.mapper.impl;

import com.base.domain.*;
import com.base.dto.moduleIA.ItemMealDto;
import com.base.dto.moduleIA.MealDtoResponse;
import com.base.dto.moduleIA.MealPlanDtoResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MealPlanMapper {

    public MealPlan toEntity(MealPlanDtoResponse dto, ProfileNutrition profileNutrition){

        MealPlan mealPlanEntity = new MealPlan();
        mealPlanEntity.setProfileNutrition(profileNutrition);
        mealPlanEntity.setTotalCalories(dto.getTotalCalories());
        mealPlanEntity.setCompleted(false);

        List<Meal> mealListEntity = new ArrayList<>();
        for(MealDtoResponse mealDtoResponse : dto.getMeals()){

            Meal mealEntity = new Meal();
            mealEntity.setMealPlan(mealPlanEntity);
            mealEntity.setMealName(mealDtoResponse.getMealName());

            MappingMeal mappingMealEntity = new MappingMeal();
            mappingMealEntity.setId(mealDtoResponse.getId());

            mealEntity.setIdMappingMeal(mappingMealEntity);

            List<ItemMeal> itemMealListEntity = new ArrayList<>();
            for(ItemMealDto itemMealDto : mealDtoResponse.getItems()){
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
