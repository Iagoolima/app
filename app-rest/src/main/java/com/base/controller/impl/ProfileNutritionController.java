package com.base.controller.impl;

import com.base.controller.BaseController;
import com.base.controller.ICrudController;
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
public class ProfileNutritionController extends BaseController implements ICrudController<RegisterProfileNutritionDtoRequest, Object, Object, Object> {

    @Autowired
    private ProfileNutritionProcessor processor;

    @Override
    @PostMapping("/register")
    public ResponseEntity<?> register( @RequestBody @Valid RegisterProfileNutritionDtoRequest dto) {
        return processor.registerProcessor(dto);
    }

    @Override
    @PostMapping("/update")
    public ResponseEntity update(Object dto) {
        return null;
    }

    @Override
    @PostMapping("/delete")
    public ResponseEntity delete(Object dto) {
        return null;
    }

    @Override
    @PostMapping("/find")
    public ResponseEntity find(Object dto) {
        return null;
    }
}
