package com.shana.house.controller;

import com.shana.house.model.House;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("addhouse")
    public void addHouseNameAndDes(@RequestBody House house){
        //差一个uid(Session)
        System.out.println(house);
    }
}

