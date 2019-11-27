package com.shana.house.controller;

import com.google.gson.Gson;
import com.netflix.ribbon.proxy.annotation.Http;
import com.shana.house.model.House;
import com.shana.house.model.User;
import com.shana.house.qv.UserD;
import com.shana.house.qv.UserP;
import com.shana.house.service.IFrontUserService;
import com.shana.house.service.PhoneCode;
import com.shana.house.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    @Autowired
    UploadService uploadService;

    @RequestMapping("login")
    public String Login(@RequestBody User user,HttpSession session){
        User user1 = frontUserService.Login(user);
        if(user1==null){
            return "0";
        }
       String account= user.getAccount();
        session.setAttribute("user",account);
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

    //查询个人信息
    @RequestMapping("myInfo")
    public User myInfo(HttpSession session){
        String account= (String) session.getAttribute("user");
        return frontUserService.sekectByAccount(account);
    }

    //生日时间处理
    @RequestMapping("birth")
    public String birth(@RequestBody  String birth,HttpSession session) throws ParseException {
        String a=birth.split(":")[1];
        String b=a.substring(1,a.length()-2);
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
        long age=(date.getTime()-sdf.parse(b).getTime())/1000/365/24/60/60+1;
        String account= (String) session.getAttribute("user");
        Integer age1=new Integer((int)age);
        frontUserService.changeAge(account,sdf.parse(b),age1);
        return  ""+age;
    }
    //修改性別
    @RequestMapping("changeSex")
    public String changeSex(@RequestBody  User user,HttpSession session){
        String account= (String) session.getAttribute("user");
        frontUserService.changeSxe(account,user.getSex());
        return "1";
    }

    @RequestMapping("changePhone")
    public String changeEmail(@RequestBody  String mobilephone,HttpSession session){
        String account= (String) session.getAttribute("user");
        String a=mobilephone.split(":")[1];
        String b=a.substring(1,a.length()-2);
        System.out.println(account);
        System.out.println(mobilephone);
        frontUserService.changePhone(account,b);
        return "1";
    }

    @RequestMapping("changeEmail")
    public String changePhone(@RequestBody  String email,HttpSession session){
        String account= (String) session.getAttribute("user");
        String a=email.split(":")[1];
        String b=a.substring(1,a.length()-2);

        frontUserService.changeEmail(account,b);
        return "1";
    }
    //修改个人头像
    @RequestMapping("uploadImg")
    public String uploadImg(@RequestParam("file") MultipartFile file,HttpSession session){
        String account= (String) session.getAttribute("user");
        String upload = uploadService.upload(file);
        frontUserService.changeImg(account,upload);
        return upload;
    }


}


