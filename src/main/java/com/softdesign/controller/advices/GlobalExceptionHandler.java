package com.softdesign.controller.advices;

import com.softdesign.exceptions.ProfileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by malek on 11/02/17.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProfileNotFoundException.class)
    @ResponseBody
    public ErrorResponse profileNotFound(ProfileNotFoundException e)
    {
        return new ErrorResponse(ErrorMessage.usernameUnknwon, e.getMessage());
    }
}
