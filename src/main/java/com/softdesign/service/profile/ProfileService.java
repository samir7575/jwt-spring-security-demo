package com.softdesign.service.profile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softdesign.model.profile.DetailedProfile;
import com.softdesign.model.profile.MinimalProfile;
import com.softdesign.model.profile.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * Created by malek on 05/02/17.
 */
@Service
public class ProfileService implements IProfileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileService.class);

    private List<Profile> profiles;

    @Autowired
    private ResourceLoader resourceLoader;

    public ProfileService() throws IOException, URISyntaxException {


    }

    @Override
    public Optional<Profile> get(String username) throws IOException, URISyntaxException {
        LOGGER.debug("Invoking get with username={}", username);

        ClassPathResource classPathResource = new ClassPathResource("profiles.json");
        LOGGER.debug("jsonFile url ===={}", classPathResource.getFile().getAbsolutePath());

        File PROFILES_FILE = classPathResource.getFile();

        ObjectMapper objectMapper = new ObjectMapper();
        profiles = objectMapper.readValue(PROFILES_FILE, new TypeReference<List<Profile>> () {

        });

        return profiles.stream().filter(profile -> profile.getLogin().getUsername().equals(username))
                    .findFirst();
    }

    @Override
    public Optional<MinimalProfile> minimal(String username) throws IOException, URISyntaxException{
        LOGGER.debug("Invoking minimal with username={}", username);

        return get(username).map(profile -> new MinimalProfile(profile));
    }

    @Override
    public Optional<DetailedProfile> detailed(String username) throws IOException, URISyntaxException{
        LOGGER.debug("Invoking detailed with username={}", username);

        return get(username).map(profile -> new DetailedProfile(profile));
    }
}
