package com.shana.house.controller;

import com.shana.house.model.User;
import com.shana.house.service.IFrontUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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

    @RequestMapping("login")
    public String Login(@RequestBody User user){
        User user1 = frontUserService.Login(user);
        if(user1==null){
            return "0";
        }
        return "1";
    }

    @RequestMapping("email1")
    public void sendEmail(HttpSession session){
        System.out.println("往session中存了一个值111111111111 :"+session.getId());
        session.setAttribute("username","charles");
    }

    @RequestMapping("email12")
    public String sendEmail1(HttpSession session){
        System.out.println("2222222222222222222------------>"+session.getId());
        String uname=(String)session.getAttribute("username");
        return uname;
    }
}

