package com.shana.house.service;

import com.shana.house.mapper.HouseMapper;
import com.shana.house.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public void addHouseNameAndDes(House house) {

    }
}

