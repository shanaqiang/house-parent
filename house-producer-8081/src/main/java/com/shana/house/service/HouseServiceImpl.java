package com.shana.house.service;

import com.netflix.discovery.converters.Auto;
import com.shana.house.mapper.HouseCommentMapper;
import com.shana.house.mapper.HouseImgMapper;
import com.shana.house.mapper.HouseMapper;
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
    @Override
    public HouseQv OneHouseDetailByHid(Integer hid) {
        return houseMapper.selectHouseQvByHid(hid);
    }

    @Override
    public List<HouseImg> OneHouseAllImg(int hid) {
        List<HouseImg> list=houseImgMapper.selectAllImgByHid(hid);
        return list;
    }

    @Override
    public List<HouseCommentQv> OneHouseThreeComment(int hid) {
        List<HouseCommentQv> list=houseCommentMapper.selectThreeComment(hid);
        return list;
    }
}
