package com.softdesign.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by malek on 28/01/17.
 */

@RestController
@Api(value = "AuthenticationController", description = "Service d'authentification")
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);


}
