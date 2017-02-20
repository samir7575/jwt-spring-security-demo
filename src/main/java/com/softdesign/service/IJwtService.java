package com.softdesign.service;

import com.softdesign.model.profile.MinimalProfile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

/**
 * Created by malek on 04/02/17.
 */
public interface IJwtService {

    /**
     * Token for minimal profile
     * @param minimalProfile
     * @return
     */
    public String tokenFor(MinimalProfile minimalProfile);

    /**
     * Verify Token
     * @param token
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public Optional<MinimalProfile> verify(String token) throws IOException, URISyntaxException;
}
