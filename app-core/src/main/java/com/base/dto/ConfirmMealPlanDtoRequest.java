package com.base.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class ConfirmMealPlanDtoRequest {

    private Integer idMealPlan;

    private List<ConfirmMealDtoRequest> meals;
}

