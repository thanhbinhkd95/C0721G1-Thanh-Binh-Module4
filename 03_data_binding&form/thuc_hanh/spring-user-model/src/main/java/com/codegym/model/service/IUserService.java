package com.codegym.model.service;

import com.codegym.model.Login;
import com.codegym.model.User;

public interface IUserService {
    User checkLogin(Login login);
}
