package com.base.constants;

import java.text.MessageFormat;
import java.util.UUID;

public class MessageLoggerConstants {

    public static String error(UUID idUser, String messageLogger, String className){
        return MessageFormat.format(">>>>> ERROR >>>>>  ID usuario: {0} -> {1} | classe: {2}", idUser.toString(), messageLogger, className);
    }
}
