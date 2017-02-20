package com.softdesign.controller;

import com.softdesign.model.User;
import com.softdesign.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by malek on 28/01/17.
 */

@RestController
@RequestMapping(UserController.User_CONTROLLER_PATH)
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    public static final String User_CONTROLLER_PATH = "/users";

    @Autowired
    private IUserService userService;

    /**
     * GET /get-by-email --> Return the id for the user having the passed email.
     */
    @RequestMapping(value = "/get-by-email", method = RequestMethod.GET, produces = RestMediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Récupérer un utilisateur à partir de son email.")
    public User getUserByEmail(@RequestParam("email") String email, HttpServletRequest request)
    {
        LOGGER.info("Invoking getUserByEmail for user with email ={}", email);
        LOGGER.info(request + "");
        User userDTO = null;
        try
        {
            userDTO = userService.findByEmail(email);
        } catch (Exception ex)
        {
            return null;
        }
        return userDTO;
    }
}
