package com.base.business.application;

import com.base.constants.MessageLoggerConstants;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

@Data
public class BusinessApplication<T extends BusinessApplication<T>> {

    private static final Logger logger = LoggerFactory.getLogger(Business.class);

    private ErrorResponse messageError = new ErrorResponse();

    private boolean error = false;

    public void setError(String message) {
        if (!error) {
            this.messageError.setMessage(message);
            this.error = true;
        }
    }

    public void setError(String message, UUID idUser, Class<?> className) {
        if (!error) {
            this.messageError.setMessage(message);
            this.error = true;
            logger.error(MessageLoggerConstants.error(idUser, message, String.valueOf(className)));
        }
    }

    @SuppressWarnings("unchecked")
    protected Class<T> getGenericClass() {
        return (Class<T>) ((java.lang.reflect.ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public T getInstance() {
        return (T) SessionDataManager.getData(getGenericClass());
    }

    @SuppressWarnings("unchecked")
    public static <T extends BusinessApplication<T>> T getStaticInstance(Class<T> clazz) {
        return (T) SessionDataManager.getData(clazz);
    }

    public void setInstance(T data) {
        SessionDataManager.setData(getGenericClass(), data);
    }

    public static <T extends BusinessApplication<T>> void setStaticInstance(Class<? extends BusinessApplication<?>> clazz,
                                                                            BusinessApplication<?> data) {
        SessionDataManager.setData(clazz, data);
    }
}