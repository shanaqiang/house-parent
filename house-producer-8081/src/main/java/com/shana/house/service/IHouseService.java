package com.shana.house.service;

import com.shana.house.model.HouseBed;
import com.shana.house.model.HouseComment;
import com.shana.house.model.HouseImg;
import com.shana.house.qv.HouseCommentQv;
import com.shana.house.qv.HouseQv;

import java.util.List;

public interface IHouseService {

    HouseQv oneHouseDetailByHid(Integer hid);

    List<HouseImg> oneHouseAllImg(int hid);

    List<HouseCommentQv> oneHouseThreeComment(int hid);

    List<HouseBed> oneHouseBed(int hid);

    int oneHouseCommentCount(int hid);
}
