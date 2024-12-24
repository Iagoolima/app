package com.base.mapper.impl;

import com.base.domain.ItemMeal;
import com.base.domain.Meal;
import com.base.dto.FindMealGeneratedDtoResponse;
import com.base.dto.ItemMealGenericDtoResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MealMapper {

    public FindMealGeneratedDtoResponse toDtoFindMealGeneratedDtoResponse(Integer idMealPlan, Meal meal){

        FindMealGeneratedDtoResponse dto = new FindMealGeneratedDtoResponse();
        dto.setIdMealPlan(idMealPlan);
        dto.setMealId(meal.getId());
        dto.setName(meal.getMealName());
        dto.setTimerInit(meal.getIdMappingMeal().getTimerInit());
        dto.setTimerEnd(meal.getIdMappingMeal().getTimerEnd());

        List<ItemMealGenericDtoResponse> listItemMealDto = new ArrayList<>();
        for(ItemMeal itemMeal: meal.getItems()){
            ItemMealGenericDtoResponse itemMealdto = new ItemMealGenericDtoResponse();
            itemMealdto.setId(itemMeal.getId());
            itemMealdto.setFood(itemMeal.getFood());
            itemMealdto.setDetails(itemMeal.getDetails());
            itemMealdto.setQuantity(itemMeal.getQuantity());
            itemMealdto.setCalories(itemMeal.getCalories());
            listItemMealDto.add(itemMealdto);
        }

        dto.setItems(listItemMealDto);

        return dto;
    }

}
