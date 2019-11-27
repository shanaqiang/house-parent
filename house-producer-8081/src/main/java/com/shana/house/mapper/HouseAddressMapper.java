package com.shana.house.mapper;

import com.shana.house.model.HouseAddress;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface HouseAddressMapper {

    @Insert("insert into t_houseaddress (hid,province,city,yard,loc,createdate,status) values (#{hid},#{province}," +
            "#{city},#{yard},#{loc},#{createdate},#{status})")
    void insertHouseAddress(HouseAddress houseAddress);

    @Select("select * from t_houseaddress where hid=#{hid}")
    HouseAddress selectByHid(int hid);

    @Delete("delete from t_houseaddress where hid=#{hid}")
    void deleteHouseAddressByHid(int hid);
}
