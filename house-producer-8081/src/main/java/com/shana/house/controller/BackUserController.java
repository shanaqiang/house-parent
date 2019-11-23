package com.shana.house.controller;

import com.shana.house.mapper.UserMapper;
import com.shana.house.model.User;
import com.shana.house.rs.BackUserVo;
import com.shana.house.rs.ResponseResult;
import com.shana.house.service.IBackUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author EDZ
 * @create 2019/11/19
 * @since 1.0.0
 */
@RestController
@RequestMapping("/backuser")
public class BackUserController {
    @Autowired
    private IBackUserService backUserService ;

    @RequestMapping("/queryAll/{pageIndex}/{pageSize}")
    public ResponseResult queryAll(@PathVariable int pageIndex, @PathVariable int pageSize) {
        return backUserService.findAll(pageIndex,pageSize) ;
    }

    @RequestMapping("/queryUser")
    public ResponseResult queryUser(BackUserVo vo) {
        return backUserService.findUser(vo) ;
    }

    @RequestMapping("/motify")
    public void motify(@RequestBody User u) {
        backUserService.update(u) ;
    }

    @RequestMapping("/motifystatusbyids")
    public void motifystatusbyids(@RequestBody BackUserVo vo) {
        System.out.println(vo);
        backUserService.updateUserStatusByIds(vo);
    }

}
