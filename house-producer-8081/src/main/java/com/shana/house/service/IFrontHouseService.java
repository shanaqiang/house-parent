package com.shana.house.service;

import com.shana.house.model.House;
import com.shana.house.model.HouseInstallations;
import com.shana.house.model.HouseRule;

import java.util.List;

public interface IFrontHouseService {
    void addHouseNameAndDes(House house, String[] imgs1);

    void updateHouseMes(House house);

    void addHouseInstallations(HouseInstallations houseInstallations);

    void addHouseRule(HouseRule houseRule);

    House findHouseByHid(int hid);

    void updateHousePriceAndDate(House house);

    List<House> findHouseByUid(String uid);

    HouseInstallations findHouseInstallationsByHid(String hid);

    List<House> findHouseByUid(int uid);
}
