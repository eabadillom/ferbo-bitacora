package com.ferbo.bitacora.exception;

public class BitacoraException extends RuntimeException {

    private final String code;

    public BitacoraException(String message) {
        super(message);
        this.code = null;
    }

    public BitacoraException(String message, Throwable cause) {
        super(message, cause);
        this.code = null;
    }

    public BitacoraException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BitacoraException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BitacoraException(Throwable cause) {
        super(cause);
        this.code = null;
    }

    public String getCode() {
        return code;
    }
}

