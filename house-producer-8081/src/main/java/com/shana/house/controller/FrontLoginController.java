package com.shana.house.controller;

import com.shana.house.model.User;
import com.shana.house.service.IFrontUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author xiana
 * @create 2019/11/19
 * @since 1.0.0
 */
@RequestMapping("front")
@RestController
public class FrontLoginController {
    @Autowired
    IFrontUserService frontUserService;

    @RequestMapping("login")
    public String Login(@RequestBody User user){
        User user1 = frontUserService.Login(user);
        if(user==null){
            return "0";
        }
        return "1";
    }
}

