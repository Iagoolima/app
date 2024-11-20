package com.base.controller.impl;

import com.base.controller.BaseController;
import com.base.controller.ICrudController;
import com.base.processor.MealPlanProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/meal-plan")
public class MealPlanController extends BaseController implements ICrudController {

    @Autowired
    private MealPlanProcessor processor;

    @PostMapping("/generate")
    public ResponseEntity register1() {
        return processor.registerProcessor();
    }

    @Override
    public ResponseEntity register(Object dto) {
        return null;
    }

    @Override
    public ResponseEntity update(Object dto) {
        return null;
    }

    @Override
    public ResponseEntity delete(Object dto) {
        return null;
    }

    @Override
    public ResponseEntity find(Object dto) {
        return null;
    }
}
