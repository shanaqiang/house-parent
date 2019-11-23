package com.shana.house.service;

import com.shana.house.model.User;
import com.shana.house.rs.BackUserVo;
import com.shana.house.rs.ResponseResult;

import java.util.List;

public interface IBackUserService {
    ResponseResult findAll(int index,int size) ;

    void update(User u) ;

    ResponseResult findUser(BackUserVo vo) ;

    void updateUserStatusByIds(BackUserVo vo) ;
}
