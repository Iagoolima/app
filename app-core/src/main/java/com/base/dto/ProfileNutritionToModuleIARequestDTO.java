package com.base.dto;

import com.base.domain.ProfileNutrition;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileNutritionToModuleIARequestDTO {

    private String name;

    private ProfileNutrition profileNutrition;
}
