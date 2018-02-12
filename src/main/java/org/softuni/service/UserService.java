package org.softuni.service;

import org.softuni.model.bindingModel.LoginModel;

public interface UserService {

    LoginModel createUser(LoginModel loginModel);

    LoginModel findByUsernameAndPassword(String username, String password);

}
