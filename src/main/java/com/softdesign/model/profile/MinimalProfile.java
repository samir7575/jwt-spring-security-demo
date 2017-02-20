package com.softdesign.model.profile;

import java.net.URL;

/**
 * Created by malek on 04/02/17.
 */
public class MinimalProfile {

    private final String username;
    private final Name name;
    private final URL thumbnail;

    public MinimalProfile(Profile profile) {
        name = profile.getName();
        username = profile.getLogin().getUsername();
        this.thumbnail = profile.getPicture().getThumbnail();
    }

    public String getUsername() {
        return username;
    }

    public Name getName() {
        return name;
    }

    public URL getThumbnail() {
        return thumbnail;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MinimalProfile{");
        sb.append("username='").append(username).append('\'');
        sb.append(", name=").append(name);
        sb.append(", thumbnail=").append(thumbnail);
        sb.append('}');
        return sb.toString();
    }
}
