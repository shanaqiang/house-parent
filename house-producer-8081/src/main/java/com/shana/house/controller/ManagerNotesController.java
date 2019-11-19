package com.shana.house.controller;

import com.shana.house.model.ManagerNotes;
import com.shana.house.service.IManagerNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author EDZ
 * @create 2019/11/18
 * @since 1.0.0
 */
@RestController
@RequestMapping("/managernotes")
public class ManagerNotesController {
    @Autowired
    private IManagerNotesService managerNotesService ;

    @RequestMapping("/queryAll/{mid}")
    public List<ManagerNotes> queryAll(@PathVariable(value = "mid") int mid){
        return managerNotesService.findAllByMid(mid) ;
    }

    @RequestMapping("/add")
    public void add(@RequestBody ManagerNotes mn) {
        managerNotesService.add(mn);
    }

    @RequestMapping("/remove/{nid}")
    public void remove(@PathVariable(value = "nid") int nid) {
        managerNotesService.remove(nid);
    }

    @PutMapping("/motify")
    public void motify(@RequestBody ManagerNotes mn) {
        if(mn.getStatus()==0){
            mn.setStatus(1);
        }else{
            mn.setStatus(0);
        }
        managerNotesService.motify(mn);
    }

}
