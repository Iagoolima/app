package com.base.business.application;

import com.base.domain.User;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Business extends BusinessApplication<Business> {

    private User user;

    private Map<Class<?>, Object> objects;

    public Business() {
        objects = new HashMap<>();
    }

    // Adiciona um objeto ao mapa interno
    public <O> void addObject(O object) {
        objects.put(object.getClass(), object);
    }

    // Recupera um objeto pelo tipo
    public <O> O getObject(Class<O> clazz) {
        return clazz.cast(objects.get(clazz));
    }

    // Inicializa a instância da sessão para o Business atual
    public void initialize() {
        SessionDataManager.setData(this.getClass(), this);
    }

    // Recupera a instância de Business associada à thread atual
    public static Business getSession() {
        return SessionDataManager.getData(Business.class);
    }
}