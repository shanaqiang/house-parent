package com.shana.house.controller;

import com.netflix.discovery.converters.Auto;
import com.shana.house.model.HouseBed;
import com.shana.house.model.HouseComment;
import com.shana.house.model.HouseImg;
import com.shana.house.qv.HouseCommentQv;
import com.shana.house.qv.HouseQv;
import com.shana.house.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author asus
 * @create 2019/11/20
 * @since 1.0.0
 */
@RestController
@RequestMapping("house")
public class HouseController {
    @Autowired
    IHouseService houseService;
    @GetMapping("housedetail/{hid}")
    public HouseQv showOneHouseDetail(@PathVariable("hid") int hid){
        HouseQv houseQv=houseService.oneHouseDetailByHid(hid);
        return houseQv;
    }

    @GetMapping("houseimg/{hid}")
    public List<HouseImg> showOneHouseAllImg(@PathVariable("hid") int hid){
        List<HouseImg> listimgs=houseService.oneHouseAllImg(hid);
        return listimgs;
    }

    @GetMapping("housecomment/{hid}")
    public List<HouseCommentQv> showThreeComment(@PathVariable("hid") int hid){
        List<HouseCommentQv> listcommentqvs=houseService.oneHouseThreeComment(hid);
        return listcommentqvs;
    }

    @GetMapping("housebed/{hid}")
    public List<HouseBed> showHouseBed(@PathVariable("hid") int hid){
        List<HouseBed> listHouseBed=houseService.oneHouseBed(hid);
        return listHouseBed;
    }

    @GetMapping("housecommentcount/{hid}")
    public int showHouseCommentCount(@PathVariable("hid") int hid){
        System.out.println(hid);
        int commentcount=houseService.oneHouseCommentCount(hid);
        return commentcount;
    }
}
