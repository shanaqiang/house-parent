package com.shana.house.service;

import com.shana.house.model.User;
import com.shana.house.qv.UserP;

import java.util.List;

public interface IFrontUserService {
    User Login(User user);

    List<User> findAll();
    String register(UserP user);
}
