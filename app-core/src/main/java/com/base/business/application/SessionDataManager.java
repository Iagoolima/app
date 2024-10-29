package com.base.business.application;

import java.util.HashMap;
import java.util.Map;

public class SessionDataManager {

    private static SessionDataManager instance;

    private Map<Class<?>, Object> sessionDataMap;

    private SessionDataManager() {
        sessionDataMap = new HashMap<>();
    }

    public static SessionDataManager getInstance() {
        if (instance == null) {
            instance = new SessionDataManager();
        }
        return instance;
    }

    public <T> void setData(Class<? extends BusinessApplication> clazz, BusinessApplication<?> businessApplicationData) {
        sessionDataMap.put(clazz, businessApplicationData);
    }

    public <T> T getData(Class<T> clazz) {
        return clazz.cast(sessionDataMap.get(clazz));
    }
}