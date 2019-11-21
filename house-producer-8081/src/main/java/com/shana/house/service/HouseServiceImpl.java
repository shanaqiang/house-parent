package com.shana.house.service;

import com.netflix.discovery.converters.Auto;
import com.shana.house.mapper.HouseBedMapper;
import com.shana.house.mapper.HouseCommentMapper;
import com.shana.house.mapper.HouseImgMapper;
import com.shana.house.mapper.HouseMapper;
import com.shana.house.model.HouseBed;
import com.shana.house.model.HouseComment;
import com.shana.house.model.HouseImg;
import com.shana.house.qv.HouseCommentQv;
import com.shana.house.qv.HouseQv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
