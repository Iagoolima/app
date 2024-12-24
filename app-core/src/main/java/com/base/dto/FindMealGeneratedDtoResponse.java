package com.base.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class FindMealGeneratedDtoResponse {

    private Integer idMealPlan;

    private Integer mealId;

    private String name;

    private LocalTime timerInit;

    private LocalTime timerEnd;

    private List<ItemMealGenericDtoResponse> items;

}
