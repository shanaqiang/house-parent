package com.shana.house.controller;

import com.shana.house.model.Manager;
import com.shana.house.rs.ManagerVo;
import com.shana.house.rs.ResponseResult;
import com.shana.house.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author EDZ
 * @create 2019/11/21
 * @since 1.0.0
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private IManagerService managerService ;

    @RequestMapping("/queryAll/{pageIndex}/{pageSize}")
    public ResponseResult queryAll(@PathVariable int pageIndex,@PathVariable int pageSize) {
        return managerService.findAll(pageIndex,pageSize);
    }

    @RequestMapping("/queryManager")
    public ResponseResult queryManager(ManagerVo vo) {
        return managerService.findManager(vo) ;
    }

    @RequestMapping("/queryById/{mid}")
    public Manager queryById(@PathVariable int mid) {
        return managerService.findById(mid) ;
    }

    @RequestMapping("/add")
    public void add(@RequestBody Manager manager) {
        System.out.println(manager);
        managerService.add(manager);
    }

    @RequestMapping("/motify")
    public void motify(@RequestBody Manager manager) {
        managerService.motify(manager);
    }

    @PutMapping("/motifyManager")
    public ResponseResult motifyManager(@RequestBody ManagerVo vo) {
        return managerService.motifyManager(vo);
    }

    @PutMapping("/motifystatusbyids")
    public void motifystatusbyids(ManagerVo vo) {
        managerService.motifystatusbyids(vo) ;
    }

}
