package com.softdesign.model.profile;

import java.net.URL;

/**
 * Created by malek on 11/02/17.
 */
public class Picture {

    private URL large;
    private URL medium;
    private URL thumbnail;

    public Picture() {
    }

    public URL getLarge() {
        return large;
    }

    public void setLarge(URL large) {
        this.large = large;
    }

    public URL getMedium() {
        return medium;
    }

    public void setMedium(URL medium) {
        this.medium = medium;
    }

    public URL getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(URL thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "large=" + large +
                ", medium=" + medium +
                ", thumbnail=" + thumbnail +
                '}';
    }
}
