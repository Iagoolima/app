package com.base.business.application;

import java.util.HashMap;
import java.util.Map;

public class SessionDataManager {

    private static final ThreadLocal<Map<Class<?>, Object>> threadLocalSessionData = ThreadLocal.withInitial(HashMap::new);

    private SessionDataManager() {
        // Private constructor to prevent instantiation
    }

    public static <T extends BusinessApplication<?>> void setData(Class<? extends BusinessApplication<?>> clazz, BusinessApplication<?> businessApplicationData) {
        threadLocalSessionData.get().put(clazz, businessApplicationData);
    }

    public static <T> T getData(Class<T> clazz) {
        return clazz.cast(threadLocalSessionData.get().get(clazz));
    }

    public static void clear() {
        threadLocalSessionData.remove();
    }
}