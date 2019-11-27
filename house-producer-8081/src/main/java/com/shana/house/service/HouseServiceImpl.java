package com.shana.house.service;

import com.shana.house.mapper.*;
import com.shana.house.model.*;
import com.shana.house.qv.HouseCommentQv;
import com.shana.house.qv.HouseQv;
import com.shana.house.qv.Instal;
import com.shana.house.qv.StartAndEndDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author asus
 * @create 2019/11/20
 * @since 1.0.0
 */
@Service
public class HouseServiceImpl implements IHouseService{
    @Autowired
    HouseMapper houseMapper;
    @Autowired
    HouseImgMapper houseImgMapper;
    @Autowired
    HouseCommentMapper houseCommentMapper;
    @Autowired
    HouseBedMapper houseBedMapper;
    @Autowired
    HouseInstallationsMapper houseInstallationsMapper;
    @Autowired
    OrdersMapper ordersMapper;
    @Override
    public HouseQv oneHouseDetailByHid(Integer hid) {
        return houseMapper.selectHouseQvByHid(hid);
    }

    @Override
    public List<HouseImg> oneHouseAllImg(int hid) {
        List<HouseImg> list=houseImgMapper.selectAllImgByHid(hid);
        return list;
    }

    @Override
    public List<HouseCommentQv> oneHouseThreeComment(int hid) {
        List<HouseCommentQv> list=houseCommentMapper.selectThreeComment(hid);
        return list;
    }

    @Override
    public List<HouseBed> oneHouseBed(int hid) {
        List<HouseBed> list=houseBedMapper.selectAllByHid(hid);
        return list;
    }

    @Override
    public int oneHouseCommentCount(int hid) {
        int count=houseCommentMapper.selectCountByHid(hid);
        return count;
    }

    //房屋设施
    @Override
    public List<Instal> oneHouseInstal(int hid) {
        HouseInstallations houseinstal=houseInstallationsMapper.selectOneHouseInstallations(hid);
        Field[] fields=houseinstal.getClass().getDeclaredFields();
        List<Instal> list=new ArrayList<>();
        for(int i=2;i<fields.length-2;i++){
            Instal instal=new Instal();
            try {
                fields[i].setAccessible(true);
                String name=fields[i].getName();
               // System.out.println(name);
                Object value=fields[i].get(houseinstal);
                //System.out.println(value);
                instal.setName(name);
                instal.setValue((Integer) value);
                if(instal.getValue()==1){
                    list.add(instal);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(list);
        return list;
    }

    @Override
    public List<House> AllHouseByCity(String city) {
        List<House> list=new ArrayList<>();
        if(city.equals("全部")){
            list=houseMapper.selectAllHouse1();
        }else{
            list=houseMapper.selectAllHouseByCity(city);
        }
        return list;
    }

    //日期选择
    @Override
    public List<StartAndEndDate> selectAllDate(int hid) {
        List<StartAndEndDate> datelist=new ArrayList<StartAndEndDate>();
        HouseQv houseQv=houseMapper.selectHouseQvByHid(hid);
        System.out.println(houseQv);
        StartAndEndDate saed1=new StartAndEndDate();
        saed1.setStartdate(houseQv.getStartdate());
        saed1.setEnddate(houseQv.getEnddate());
        System.out.println(saed1);
        datelist.add(saed1);
        List<Orders> orders=ordersMapper.selectOrderByHid(hid);
        for(Orders o:orders){
            StartAndEndDate saed2=new StartAndEndDate();
            saed2.setStartdate(o.getStartdate());
            saed2.setEnddate(o.getEnddate());
            datelist.add(saed2);
        }
        return datelist;
    }

}
