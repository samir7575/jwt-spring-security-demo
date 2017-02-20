package com.softdesign.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by malek on 21/01/17.
 */

@RestController
@RequestMapping(value = "/")
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> home()
    {
        return  ResponseEntity.ok("Success");
    }
}
