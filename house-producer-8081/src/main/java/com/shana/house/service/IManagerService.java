package com.shana.house.service;

import com.shana.house.model.Manager;
import com.shana.house.rs.ManagerVo;
import com.shana.house.rs.ResponseResult;

import java.util.List;

public interface IManagerService {
    Manager findById(int mid) ;
    ResponseResult findAll(int index, int size) ;
    ResponseResult findManager(ManagerVo vo) ;
    void add(Manager manager) ;
    void motify(Manager manager) ;
    ResponseResult motifyManager(ManagerVo vo) ;

    void motifystatusbyids(ManagerVo vo);
}
