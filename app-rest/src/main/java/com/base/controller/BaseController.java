package com.base.controller;

import com.base.business.application.BusinessApplication;
import com.base.business.application.SessionDataManager;

import java.util.function.Consumer;

public class BaseController {

    public static <T extends BusinessApplication<?>> T handleBusinessOperation(T sessionData, Consumer<T> facadeMethod) {
        // Armazenando a instância de sessionData no contexto da thread
        SessionDataManager.setData((Class<? extends BusinessApplication<?>>) sessionData.getClass(), sessionData);

        // Executando o método da fachada
        facadeMethod.accept(sessionData);

        // Recuperando a instância armazenada e retornando
        return (T) SessionDataManager.getData(sessionData.getClass());
    }

}