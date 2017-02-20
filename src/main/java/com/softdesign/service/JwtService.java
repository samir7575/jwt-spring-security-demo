package com.softdesign.service;

import com.nimbusds.jwt.PlainJWT;
import com.nimbusds.jwt.SignedJWT;
import com.softdesign.model.profile.MinimalProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Optional;

/**
 * Created by malek on 04/02/17.
 */
public class JwtService implements IJwtService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtService.class);

    PlainJWT plainJWT;

    @Override
    public String tokenFor(MinimalProfile minimalProfile) {
        return null;
    }

    @Override
    public Optional<MinimalProfile> verify(String jwt) throws IOException, URISyntaxException {
        try {
            plainJWT = PlainJWT.parse(jwt);

            plainJWT.getHeader();
            System.out.println(plainJWT.getJWTClaimsSet().toJSONObject());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
