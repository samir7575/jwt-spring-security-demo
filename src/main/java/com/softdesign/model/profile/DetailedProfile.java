package com.softdesign.model.profile;

/**
 * Created by malek on 04/02/17.
 */
public class DetailedProfile {

    private final Name name;
    private final String email;
    private final String username;

    public DetailedProfile(Profile profile) {
        name = profile.getName();
        email = profile.getEmail();
        username = profile.getLogin().getUsername();
    }

    public Name getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DetailedProfile{");
        sb.append("name=").append(name);
        sb.append(", email='").append(email).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
