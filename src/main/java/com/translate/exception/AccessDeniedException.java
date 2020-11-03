package com.translate.exception;

public class AccessDeniedException extends RuntimeException {

    private int code;

    public AccessDeniedException(String message) {
        super(message);
    }

    public AccessDeniedException(String message, int code) {
        super(message);
        this.code = code;
    }

    public AccessDeniedException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessDeniedException(Throwable cause) {
        super(cause);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
