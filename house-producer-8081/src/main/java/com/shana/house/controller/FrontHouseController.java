package com.shana.house.controller;

import com.google.gson.Gson;
import com.shana.house.model.*;
import com.shana.house.qv.Student;
import com.shana.house.service.IFrontHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

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
    @Autowired
    Gson gson;

    @RequestMapping("addhousename")
    public String addHouseNameAndDes(@RequestBody House house, HttpSession session){
        //差一个uid(Session)
        //
        Gson gson=new Gson();
        String house1 = gson.toJson(house, House.class);
        session.setAttribute("house",house1);
        System.out.println("往session中存入hname和description"+session.getId());
        return "1";
    }

    @RequestMapping("addhouseimg")
    public String addHouseimg(@RequestBody String arr, HttpSession session){
        String[] imgs1 = arr.split(",");
        String house1=(String)session.getAttribute("house");
        Gson gson=new Gson();
        House house = gson.fromJson(house1, House.class);
        System.out.println(house+"从session中取出的house"+session.getId());
        //将房屋信息插入数据库
        if(house==null){
            return "0";
        }
        if(session.getAttribute("hid")!=null){
            int hid=(int)session.getAttribute("hid");
            house.setHid(hid);
        }
        houseService.addHouseNameAndDes(house,imgs1);
        //往session中 存储了hid
        session.setAttribute("hid",house.getHid());
        return "1";
    }

    @RequestMapping("addhousetype")
    public String addHouseType(@RequestBody House house,HttpSession session){
        if(session.getAttribute("hid")==null){
            return "0";
        }
        Gson gson=new Gson();
        String s = gson.toJson(house, House.class);
        session.setAttribute("house",s);
        System.out.println("往session中存入了house"+s);
        return "1";
    }

    @RequestMapping("addhouselocation")
    public String addHouseLocation(@RequestBody House house,HttpSession session){
        if(session.getAttribute("hid")==null){
            return "0";
        }
        String hid=session.getAttribute("hid")+"";
        String s=(String)session.getAttribute("house");
        House house1 = gson.fromJson(s, House.class);
        System.out.println(house.getLocation());
        house1.setLocation(house.getLocation());
        house1.setCity(house.getCity());
        house1.setHid(Integer.parseInt(hid));
        //
        houseService.updateHouseMes(house1);
        return "1";
    }

    @RequestMapping("addhouseinstallations")
    public String addHouseInstallation(@RequestBody HouseInstallations houseInstallations, HttpSession session){
        System.out.println(houseInstallations);
        if(session.getAttribute("hid")==null){
            return "0";
        }
        int hid = (int)session.getAttribute("hid");
        houseInstallations.setHid(hid);
        houseInstallations.setCreatedate(new Date());
        houseInstallations.setStatus(1);
        houseService.addHouseInstallations(houseInstallations);
        return "1";
    }

    @RequestMapping("addhouserule")
    public String addHouseRule(@RequestBody HouseRule houseRule,HttpSession session){
        int hid=(int)session.getAttribute("hid");
        houseRule.setHid(hid);
        houseRule.setCreatedate(new Date());
        houseRule.setStatus(1);
        houseRule.setOthers(1);
        System.out.println(houseRule);
        houseService.addHouseRule(houseRule);
        return "1";
    }

    @RequestMapping("addhouse02")
    public String addHouse02(@RequestBody House house,HttpSession session){
        if(session.getAttribute("hid")==null){
            return "0";
        }
        int hid=(int)session.getAttribute("hid");
        house.setHid(hid);
        house.setStatus(0);
        System.out.println(house);
        houseService.updateHousePriceAndDate(house);
        return "1";
    }



    @RequestMapping("test01")
    public void test01(HttpSession session){
        Student student=new Student(11,"charles","男");
        /*Gson gson=new Gson();
        String s = gson.toJson(student, Student.class);*/
        session.setAttribute("test",student);
        System.out.println("往session中存入了charles"+session.getId());
    }

    @RequestMapping("test02")
    public Student test02(HttpSession session){
        Student s = (Student) session.getAttribute("test");
        /*Gson gson=new Gson();
        Student test = gson.fromJson(s, Student.class);*/
        System.out.println(session.getId());
        return s;
    }

    @RequestMapping("getmes02")
    public String getMes02(HttpSession session){
        if(session.getAttribute("hid")==null) {
            return "0";
        }
        String hid= session.getAttribute("hid")+"";
        if(houseService.findHouseInstallationsByHid(hid)==null){
            return "1";
        }
        return "2";
    }

    @RequestMapping("cleansession")
    public void cleanSession(HttpSession session){
        if(session.getAttribute("hid")!=null){
            session.removeAttribute("hid");
        }
    }

    @RequestMapping("finduserhouse")
    public List<House> findHouseByUser(HttpSession session){
        /*String user1 = (String)session.getAttribute("user");
        User user = gson.fromJson(user1, User.class);
        return houseService.findHouseByUid(user.getUid());*/
        //先默认写uid=3
        return houseService.findHouseByUid(3);
    }

    @RequestMapping("sethid/{hid}")
    public void setHid(@PathVariable("hid")int hid,HttpSession session){
        session.setAttribute("hid",hid);
    }

    @RequestMapping("findhousehid")
    public House findHouseHid(HttpSession session){
        if(session.getAttribute("hid")==null){
            return null;
        }
        int hid=(int)session.getAttribute("hid");
        return houseService.findHouseByHid(hid);
    }

    @RequestMapping("findhouseinstallationshid")
    public HouseInstallations findHouseInstallationsHid(HttpSession session){
        if(session.getAttribute("hid")==null){
            return null;
        }
        int hid=(int)session.getAttribute("hid");
        return houseService.findHouseInstallationsByHid(hid+"");
    }

    @RequestMapping("findhouserulehid")
    public HouseRule findHouseRuleHid(HttpSession session){
        if(session.getAttribute("hid")==null){
            return null;
        }
        int hid=(int)session.getAttribute("hid");
        return houseService.findHouseRuleByHid(hid);
    }

    @RequestMapping("addhouseaddress")
    public String addHouseAddress(@RequestBody HouseAddress houseAddress,HttpSession session){
        if(session.getAttribute("hid")==null){
            return "0";
        }
        int hid=(int)session.getAttribute("hid");
        houseAddress.setHid(hid);
        houseAddress.setCreatedate(new Date());
        houseAddress.setStatus(1);
        System.out.println(houseAddress);
        houseService.addHouseAddress(houseAddress);
        return "1";
    }

    @RequestMapping("findhouseaddresshid")
    public HouseAddress findHouseAddressHid(HttpSession session){
        if(session.getAttribute("hid")==null){
            return null;
        }
        int hid=(int)session.getAttribute("hid");
        return houseService.findHouseAddressByHid(hid);
    }

    @RequestMapping("findhouseimghid")
    public List<HouseImg> findHouseImgHid(HttpSession session){
        if(session.getAttribute("hid")==null){
            return null;
        }
        int hid=(int)session.getAttribute("hid");
        return houseService.findHouseImgHid(hid);
    }


}

