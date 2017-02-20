package com.softdesign.service;

import com.softdesign.dao.UserDAO;
import com.softdesign.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by malek on 27/01/17.
 */
@Service("userService")
@Transactional
public class UserService implements IUserService
{
    @Autowired
    UserDAO userDAO;

    @Override
    public User loadUserByUserName(String userName) {
        return null;
    }

    @Override
    public long post(User user) {
        // TODO
        return 0;
    }

    @Override
    public User getById(long id) {
        return userDAO.findOne(id);
    }

    @Override
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }
}
