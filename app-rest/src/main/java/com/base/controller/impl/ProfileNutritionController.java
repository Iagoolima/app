package com.base.controller.impl;

import com.base.controller.BaseController;
import com.base.dto.RegisterProfileNutritionDtoRequest;
import com.base.processor.ProfileNutritionProcessor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/profile-nutrition")
public class ProfileNutritionController extends BaseController {

    @Autowired
    private ProfileNutritionProcessor processor;

    @PostMapping("/register")
    public ResponseEntity<?> register( @RequestBody @Valid RegisterProfileNutritionDtoRequest dto) {
        return processor.registerProcessor(dto);
    }

}
