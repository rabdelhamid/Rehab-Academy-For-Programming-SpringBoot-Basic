package com.example.demo.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class LocalizedBusinessException extends RuntimeException {

    private Object[] params = null;

    public LocalizedBusinessException(String message) {
        super(message);
    }

    public LocalizedBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public LocalizedBusinessException(String message, Object[] params) {
        super(message);
        this.params = params;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

}
