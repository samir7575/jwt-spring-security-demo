package com.softdesign.service;

import com.softdesign.model.User;

/**
 * Created by malek on 27/01/17.
 */
public interface IUserService {

    User loadUserByUserName(String userName);

    long post(User user);

    User getById(long id);

    public User findByEmail(final String email);
}
