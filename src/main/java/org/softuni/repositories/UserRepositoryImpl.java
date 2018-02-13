package org.softuni.repositories;

import org.softuni.entity.User;
import java.util.Map;
import java.util.TreeMap;

public class UserRepositoryImpl implements UserRepository{

    private static UserRepositoryImpl userRepository;

    private Map<String, User> users = new TreeMap<>();

    private UserRepositoryImpl(){
    }

    public static UserRepositoryImpl getInstance(){

        if(userRepository == null){
            userRepository = new UserRepositoryImpl();
        }

        return userRepository;
    }

    @Override
    public User createUser(User user) {
        this.users.put(user.getUsername(), user);

        this.users.get(user.getUsername());

        return user;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = this.users.get(username);

        if(user.getPassword().equals(password)){
            return user;
        }

        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return this.users.get(username);
    }
}
