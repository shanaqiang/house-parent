package com.shana.house.service;

import com.shana.house.model.User;

import java.util.List;

public interface IFrontUserService {
    User Login(User user);

    List<User> findAll();
}
