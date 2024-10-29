package com.base.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ICrudController<TRegister, TUpdate, TDelete, TFind> {

    ResponseEntity register(@RequestBody @Valid TRegister dto);

    ResponseEntity update(@RequestBody @Valid TUpdate dto);

    ResponseEntity delete(@RequestBody @Valid TDelete dto);

    ResponseEntity find(@RequestBody @Valid TFind dto);

}
