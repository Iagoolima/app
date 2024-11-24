package com.base.dto.moduleIA;

import com.base.domain.ProfileNutrition;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileNutritionToModuleIADtoRequest {

    private String name;

    private ProfileNutrition profileNutrition;
}
