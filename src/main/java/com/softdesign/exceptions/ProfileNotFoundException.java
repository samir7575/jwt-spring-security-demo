package com.softdesign.exceptions;


import static java.lang.String.format;

/**
 * Created by malek on 11/02/17.
 */
public class ProfileNotFoundException extends RuntimeException{

    public ProfileNotFoundException(String username) {
        super(format("Profile with username %s does not exist", username));
    }
}
