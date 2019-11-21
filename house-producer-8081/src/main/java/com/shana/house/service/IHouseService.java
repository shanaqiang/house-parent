package com.shana.house.service;

import com.shana.house.model.HouseComment;
import com.shana.house.model.HouseImg;
import com.shana.house.qv.HouseCommentQv;
import com.shana.house.qv.HouseQv;

import java.util.List;

public interface IHouseService {

    HouseQv OneHouseDetailByHid(Integer hid);

    List<HouseImg> OneHouseAllImg(int hid);

    List<HouseCommentQv> OneHouseThreeComment(int hid);
}
