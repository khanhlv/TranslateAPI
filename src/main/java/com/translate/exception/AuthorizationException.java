package com.translate.exception;

public class AuthorizationException extends RuntimeException {

    private int code;

    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(String message, int code) {
        super(message);
        this.code = code;
    }

    public AuthorizationException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public AuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorizationException(Throwable cause) {
        super(cause);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
