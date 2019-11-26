package com.shana.house.service;

import com.shana.house.mapper.*;
import com.shana.house.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
@Service
@Transactional
public class FrontHouserServiceImp implements IFrontHouseService {
    @Autowired
    HouseMapper houseMapper;
    @Autowired
    HouseImgMapper houseImgMapper;
    @Autowired
    HouseInstallationsMapper houseInstallationsMapper;
    @Autowired
    HouseRuleMapper houseRuleMapper;
    @Autowired
    HouseAddressMapper houseAddressMapper;

    @Override
    public void addHouseNameAndDes(House house, String[] imgs1) {
        System.out.println("触发了上传数据库的方法");
        //将房屋名称插入数据库
        house.setCreatedate(new Date());
        houseMapper.insertHnameAndDes(house);
        //处理房屋图片并且插入数据库
        List<HouseImg> imgs=new ArrayList<>();
        for(String str:imgs1){
            HouseImg houseImg=new HouseImg();
            houseImg.setHid(house.getHid());
            houseImg.setImg(str.substring(str.indexOf("http"),str.indexOf("png")+3));
            imgs.add(houseImg);
        }
        for(int i=0;i<imgs.size();i++){
            imgs.get(i).setCreatedate(new Date());
            imgs.get(i).setStatus(1);
            houseImgMapper.insertImg(imgs.get(i));
        }
    }

    @Override
    public void updateHouseMes(House house) {
        houseMapper.updateHouseMessage(house);
    }

    @Override
    public void addHouseInstallations(HouseInstallations houseInstallations) {
        houseInstallationsMapper.insert(houseInstallations);
    }

    @Override
    public void addHouseRule(HouseRule houseRule) {
        if(houseRuleMapper.selectByHid(houseRule.getHid())!=null){
            houseRuleMapper.deleteByHid(houseRule.getHid());
        }
        houseRuleMapper.insert(houseRule);
    }

    @Override
    public House findHouseByHid(int hid) {
        return houseMapper.selectByPrimaryKey(hid);
    }

    @Override
    public void updateHousePriceAndDate(House house) {
        houseMapper.updateHousePriceAndDate(house);
    }

    @Override
    public List<House> findHouseByUid(String uid) {
        return houseMapper.selectHouseByUid(uid);
    }

    @Override
    public HouseInstallations findHouseInstallationsByHid(String hid) {
        return houseInstallationsMapper.selectOneHouseInstallations(Integer.parseInt(hid));
    }

    @Override
    public List<House> findHouseByUid(int uid) {
        return houseMapper.selectHouseByUid(uid+"");
    }

    @Override
    public HouseRule findHouseRuleByHid(int hid) {
        return houseRuleMapper.selectByHid(hid);
    }

    @Override
    public void addHouseAddress(HouseAddress houseAddress) {
        if(houseAddressMapper.selectByHid(houseAddress.getHid())!=null){
            houseAddressMapper.deleteHouseAddressByHid(houseAddress.getHid());
        }
        houseAddressMapper.insertHouseAddress(houseAddress);
    }

    @Override
    public HouseAddress findHouseAddressByHid(int hid) {
        return houseAddressMapper.selectByHid(hid);
    }


}

