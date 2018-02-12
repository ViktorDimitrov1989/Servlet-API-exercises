package org.softuni.serviceImpl;

import org.modelmapper.ModelMapper;
import org.softuni.entity.User;
import org.softuni.model.bindingModel.LoginModel;
import org.softuni.repositories.UserRepository;
import org.softuni.repositories.UserRepositoryImpl;
import org.softuni.service.UserService;

public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserServiceImpl(){
        this.userRepository = UserRepositoryImpl.getInstance();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public LoginModel createUser(LoginModel loginModel) {

        if(this.userRepository.findUserByUsername(loginModel.getUsername()) != null){
            //handle error - this user already exists
        }

        User registeredUser = this.userRepository.createUser(this.modelMapper.map(loginModel, User.class));

        return this.modelMapper.map(registeredUser, LoginModel.class);
    }

    @Override
    public LoginModel findByUsernameAndPassword(String username, String password) {
        User user = this.userRepository.findByUsernameAndPassword(username, password);

        if(user == null){
            //handle error - Invalid username or password
        }

        return this.modelMapper.map(user, LoginModel.class);
    }
}
