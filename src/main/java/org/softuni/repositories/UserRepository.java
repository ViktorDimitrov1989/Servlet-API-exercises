package org.softuni.repositories;

import org.softuni.entity.User;

public interface UserRepository {

    User createUser(User user);

    User findByUsernameAndPassword(String username, String password);

    User findUserByUsername(String username);
}
