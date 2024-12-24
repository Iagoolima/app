package com.base.domain;

import lombok.Data;

import java.util.List;

@Data
public class ConfirmMealPlan {

    private Integer idMealPlan;

    private List<ConfirmMeal> meals;
}

