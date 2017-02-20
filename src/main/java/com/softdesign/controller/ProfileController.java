package com.softdesign.controller;

import com.softdesign.exceptions.ProfileNotFoundException;
import com.softdesign.model.profile.DetailedProfile;
import com.softdesign.model.profile.MinimalProfile;
import com.softdesign.service.profile.IProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by malek on 04/02/17.
 */

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    IProfileService profileService;


    @RequestMapping(path = "/{username}", method = RequestMethod.GET, produces = RestMediaType.APPLICATION_JSON_VALUE)
    public MinimalProfile minimalProfile(@PathVariable String username) throws IOException, URISyntaxException
    {
        return profileService.minimal(username).orElseThrow(() -> new ProfileNotFoundException(username));
    }

    @RequestMapping(path = "/details/{username}", method = RequestMethod.GET, produces = RestMediaType.APPLICATION_JSON_VALUE)
    public DetailedProfile detailedProfile(@PathVariable String username) throws IOException, URISyntaxException
    {
        return profileService.detailed(username).orElseThrow(() -> new ProfileNotFoundException(username));
    }

}
