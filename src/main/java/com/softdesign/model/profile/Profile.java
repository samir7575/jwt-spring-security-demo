package com.softdesign.model.profile;

/**
 * Created by malek on 04/02/17.
 */
public class Profile {

    private Name name;
    private String email;
    private Login login;
    private Picture picture;


    public Profile() {

    }


    public Profile(Name name, String email, Login login) {
        this.name = name;
        this.email = email;
        this.login = login;

    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name=" + name +
                ", email='" + email + '\'' +
                ", login=" + login +
                ", picture=" + picture +
                '}';
    }
}
