package com.shana.house.service;

import com.shana.house.mapper.UserMapper;
import com.shana.house.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author xiana
 * @create 2019/11/19
 * @since 1.0.0
 */
@Service
@Transactional
public class FrontUserServiceImp implements IFrontUserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public User Login(User user) {
        return userMapper.selectByAccountAndPassword(user.getAccount(),user.getPassword());
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }
}

