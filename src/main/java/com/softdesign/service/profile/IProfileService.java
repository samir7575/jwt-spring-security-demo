package com.softdesign.service.profile;

import com.softdesign.model.profile.DetailedProfile;
import com.softdesign.model.profile.MinimalProfile;
import com.softdesign.model.profile.Profile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

/**
 * Created by malek on 04/02/17.
 */
public interface IProfileService {

    public Optional<Profile> get(String username) throws IOException, URISyntaxException;

    public Optional<MinimalProfile> minimal(String username) throws IOException, URISyntaxException;

    public Optional<DetailedProfile> detailed(String username) throws IOException, URISyntaxException;


}
