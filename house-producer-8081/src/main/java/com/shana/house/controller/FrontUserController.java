package com.shana.house.controller;

import com.shana.house.model.User;
import com.shana.house.qv.UserP;
import com.shana.house.service.IFrontUserService;
import com.shana.house.service.PhoneCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class FrontUserController {
    @Autowired
    IFrontUserService frontUserService;
    @Autowired
    PhoneCode phoneCode;

    @RequestMapping("login")
    public String Login(@RequestBody User user){
        User user1 = frontUserService.Login(user);
        if(user1==null){
            return "0";
        }
        return "1";
    }

    @RequestMapping("email")
    public void sendEmail(@RequestBody String email){

    }

    //获取验证码
    @PostMapping("getPhoneCode")
    public String getPhoneCode(@RequestBody User user){
        System.out.println(user.getMobilephone());
        return phoneCode.getPhoneCode(user.getMobilephone());
    }

    //注册
    @RequestMapping("register")
    public String register(@RequestBody UserP user){
        System.out.println(user);
        return frontUserService.register(user);

    }
}


