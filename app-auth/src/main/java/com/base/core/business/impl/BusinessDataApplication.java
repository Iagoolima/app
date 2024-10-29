package com.base.core.business.impl;

import java.util.HashMap;
import java.util.Map;

public class BusinessDataApplication {

	private static BusinessDataApplication instance;

	private Map<Class<?>, Object> businessDataMap;

	private BusinessDataApplication() {
		businessDataMap = new HashMap<>();
	}

	public static BusinessDataApplication getInstance() {
		if (instance == null) {
			instance = new BusinessDataApplication();
		}
		return instance;
	}

	public <T> void setData(Class<? extends BusinessApplication> clazz, BusinessApplication<?> businessData) {
		businessDataMap.put(clazz, businessData);
	}

	public <T> T getData(Class<T> clazz) {
		return clazz.cast(businessDataMap.get(clazz));
	}

}