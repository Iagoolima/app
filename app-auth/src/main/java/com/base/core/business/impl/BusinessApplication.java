package com.base.core.business.impl;

import com.base.core.business.IBusinessApplication;
import com.base.dto.AuthUser.TokenAuthUserDtoResponse;
import lombok.Data;

import java.util.UUID;

@Data
public class BusinessApplication<T extends BusinessApplication<T>> implements IBusinessApplication {

	private UUID id;

	private ErrorResponse messageError = new ErrorResponse();

	private boolean error = false;

	private TokenAuthUserDtoResponse tokenResponse = new TokenAuthUserDtoResponse();

	public void setError(String message) {
		this.messageError.setMessage(message);
		this.error = true;
	}

	private static BusinessDataApplication businessDataApplication = BusinessDataApplication.getInstance();

	@SuppressWarnings("unchecked")
	protected Class<T> getGenericClass() {
		return (Class<T>) ((java.lang.reflect.ParameterizedType) getClass().getGenericSuperclass())
			.getActualTypeArguments()[0];
	}

	public T getInstance() {
		return (T) businessDataApplication.getData(getGenericClass());
	}

	public void setInstance(T data) {
		businessDataApplication.setData(getGenericClass(), data);
	}

	@SuppressWarnings("unchecked")
	public static <T extends BusinessApplication<T>> T getStaticInstance(Class<T> clazz) {
		return (T) businessDataApplication.getData(clazz);
	}

	public static <T extends BusinessApplication<T>> void setStaticInstance(Class<? extends BusinessApplication> clazz,
			BusinessApplication<?> data) {
		businessDataApplication.setData(clazz, data);
	}

}