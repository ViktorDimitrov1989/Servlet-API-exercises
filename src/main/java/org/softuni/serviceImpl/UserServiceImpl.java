package org.softuni.serviceImpl;

import org.modelmapper.ModelMapper;
import org.softuni.entity.User;
import org.softuni.exception.RequestException;
import org.softuni.model.bindingModel.LoginModel;
import org.softuni.repositories.UserRepository;
import org.softuni.repositories.UserRepositoryImpl;
import org.softuni.service.UserService;

public class UserServiceImpl implements UserService{

    private ModelMapper modelMapper;

    public UserServiceImpl() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public LoginModel createUser(LoginModel loginModel) {
        UserRepository userRepository = UserRepositoryImpl.getInstance();

        if(userRepository.findUserByUsername(loginModel.getUsername()) != null){
            throw new RequestException("User with this username already exists!");
        }

        User registeredUser = userRepository.createUser(this.modelMapper.map(loginModel, User.class));

        return this.modelMapper.map(registeredUser, LoginModel.class);
    }

    @Override
    public LoginModel findByUsernameAndPassword(String username, String password) {
        UserRepository userRepository = UserRepositoryImpl.getInstance();

        User user = userRepository.findByUsernameAndPassword(username, password);

        if(user == null){
            throw new RequestException("Invalid username or password");
        }

        return this.modelMapper.map(user, LoginModel.class);
    }
}
