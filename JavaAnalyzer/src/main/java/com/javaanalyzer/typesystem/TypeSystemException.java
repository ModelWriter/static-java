package com.javaanalyzer.typesystem;

public class TypeSystemException extends RuntimeException {

    public TypeSystemException() {
        super();
    }

    public TypeSystemException(String message) {
        super(message);
    }

    public TypeSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeSystemException(Throwable cause) {
        super(cause);
    }

    protected TypeSystemException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
