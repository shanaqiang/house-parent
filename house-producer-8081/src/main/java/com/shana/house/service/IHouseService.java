package com.shana.house.service;

import com.shana.house.model.*;
import com.shana.house.qv.HouseCommentQv;
import com.shana.house.qv.HouseQv;
import com.shana.house.qv.Instal;

import java.util.List;

public interface IHouseService {

    HouseQv oneHouseDetailByHid(Integer hid);

    List<HouseImg> oneHouseAllImg(int hid);

    List<HouseCommentQv> oneHouseThreeComment(int hid);

    List<HouseBed> oneHouseBed(int hid);

    int oneHouseCommentCount(int hid);

    List<Instal> oneHouseInstal(int hid);

    List<House> AllHouseByCity(String city);
}
