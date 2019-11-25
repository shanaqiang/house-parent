package com.shana.house.service;

import com.shana.house.model.User;
import com.shana.house.qv.UserP;

import java.util.Date;
import java.util.List;

public interface IFrontUserService {
    User Login(User user);

    List<User> findAll();
    String register(UserP user);

    User sekectByAccount(String account);

    void changeAge(String account, Date birthday, Integer age);

    void changeSxe(String account, String sex);


    void changeEmail(String account, String email);

    void changePhone(String account, String mobilephone);

    void changeImg(String account, String headimg);

}
