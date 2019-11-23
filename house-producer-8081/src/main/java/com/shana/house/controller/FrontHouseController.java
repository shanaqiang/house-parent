package com.shana.house.controller;

import com.google.gson.Gson;
import com.shana.house.model.House;
import com.shana.house.model.HouseRule;
import com.shana.house.qv.Student;
import com.shana.house.service.IFrontHouseService;
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
 * @create 2019/11/21
 * @since 1.0.0
 */
@RestController
@RequestMapping("house")
public class FrontHouseController {
    @Autowired
    IFrontHouseService houseService;

    @RequestMapping("addhousename")
    public String addHouseNameAndDes(@RequestBody House house, HttpSession session){
        //差一个uid(Session)
        Gson gson=new Gson();
        String house1 = gson.toJson(house, House.class);
        session.setAttribute("house",house1);
        System.out.println("往session中存入hname和description");
        return "1";
    }

    @RequestMapping("addhouseimg")
    public String addHouseimg(@RequestBody String arr, HttpSession session){
        String[] imgs1 = arr.split(",");
        String house1=(String)session.getAttribute("house");
        Gson gson=new Gson();
        House house = gson.fromJson(house1, House.class);
        System.out.println(house+"从session中取出的house");
        //将房屋信息插入数据库
        if(house==null){
            return "0";
        }
        houseService.addHouseNameAndDes(house,imgs1);
        return "1";
    }

    @RequestMapping("addhousetype")
    public String addHouseType(@RequestBody House house){
        System.out.println(house);
        return "1";
    }

    @RequestMapping("addhouselocation")
    public String addHouseLocation(@RequestBody House house){
        System.out.println(house);
        return "1";
    }

    @RequestMapping("addhouseinstallations")
    public String addHouseInstallation(@RequestBody String houseInstallations){
        System.out.println(houseInstallations);
        return "1";
    }

    @RequestMapping("addhouserule")
    public String addHouseRule(@RequestBody HouseRule houseRule){
        System.out.println(houseRule);
        return "1";
    }

    @RequestMapping("addhouse02")
    public String addHouse02(@RequestBody House house){
        System.out.println(house);
        return "1";
    }



    @RequestMapping("test01")
    public void test01(HttpSession session){
        Student student=new Student(11,"charles","男");
        Gson gson=new Gson();
        String s = gson.toJson(student, Student.class);
        session.setAttribute("test",s);
        System.out.println("往session中存入了charles"+session.getId());
    }

    @RequestMapping("test02")
    public Student test02(HttpSession session){
        String s = (String) session.getAttribute("test");
        Gson gson=new Gson();
        Student test = gson.fromJson(s, Student.class);
        System.out.println(session.getId());
        return test;
    }


}

