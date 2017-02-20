package com.softdesign.dao;

import com.softdesign.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by malek on 28/01/17.
 */
@Transactional
public interface UserDAO extends CrudRepository<User, Long>
{
    public User findByEmail(String email);
}
