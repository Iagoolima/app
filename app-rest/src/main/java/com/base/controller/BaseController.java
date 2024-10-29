package com.base.controller;

import com.base.business.application.BusinessApplication;

import java.util.function.Consumer;

public class BaseController {

    public static <T extends BusinessApplication<?>> T handleBusinessOperation(T sessionData, Consumer<T> facadeMethod) {
        BusinessApplication.setStaticInstance(sessionData.getClass(), sessionData);
        facadeMethod.accept(sessionData);
        return (T) BusinessApplication.getStaticInstance(sessionData.getClass());
    }

}
