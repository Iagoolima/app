package com.base.business.application;

import com.base.domain.User;
import lombok.Data;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

@Data
public class Business extends BusinessApplication<Business> {

    private User user;

    private Map<Class<?>, Object> objects;

    public Business() {
        objects = new HashMap<>();
    }

    public <O> void addObject(O object) {
        objects.put(object.getClass(), object);
    }

    public <O> O getObject(Class<O> clazz) {
        return clazz.cast(objects.get(clazz));
    }

    public void initialize() {
        SessionDataManager.getInstance().setData(this.getClass(), this);
    }
    public static Business getSession() {
        return SessionDataManager.getInstance().getData(Business.class);
    }
}