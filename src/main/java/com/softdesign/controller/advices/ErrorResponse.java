package com.softdesign.controller.advices;

import java.io.Serializable;

/**
 * Created by malek on 17/02/17.
 */
public class ErrorResponse implements Serializable {

    private final String status;
    private final String message;

    public ErrorResponse(String message) {
        this.message = message;
        this.status = ErrorMessage.unexpected.name();
    }

    public ErrorResponse(ErrorMessage errorMessage, String message) {
        this.status = errorMessage.name();
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
