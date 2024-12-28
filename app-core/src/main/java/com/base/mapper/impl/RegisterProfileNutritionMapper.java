package com.base.mapper.impl;

import com.base.domain.ProfileNutrition;
import com.base.domain.User;
import com.base.dto.RegisterProfileNutritionDtoRequest;
import com.base.mapper.IMapper;
import com.base.service.FocusService;
import com.base.service.RestrictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RegisterProfileNutritionMapper implements IMapper<RegisterProfileNutritionDtoRequest, ProfileNutrition> {

    @Autowired
    private FocusService focusService;

    @Autowired
    private RestrictionService restrictionService;

    @Override
    public ProfileNutrition toDomain(RegisterProfileNutritionDtoRequest dto) {
        ProfileNutrition domain = new ProfileNutrition();

        domain.setGender(dto.getGender().charAt(0));
        domain.setAge(dto.getAge());
        domain.setHeight(dto.getHeight());
        domain.setWeight(dto.getWeight());
        domain.setDesiredWeight(dto.getDesiredWeight());
        domain.setFocus(focusService.findById(dto.getFocus()));
        domain.setRestrictions(restrictionService.findAllById(dto.getRestrictions()));

        return domain;
    }

    @Override
    public RegisterProfileNutritionDtoRequest toDto(ProfileNutrition domain) {
        RegisterProfileNutritionDtoRequest dto = new RegisterProfileNutritionDtoRequest();

        dto.setAge(domain.getAge());
        dto.setHeight(domain.getHeight());
        dto.setWeight(domain.getWeight());
        dto.setDesiredWeight(domain.getDesiredWeight());

        return dto;
    }


}