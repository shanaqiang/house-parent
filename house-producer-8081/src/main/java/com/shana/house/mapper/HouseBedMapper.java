package com.shana.house.mapper;

import com.shana.house.model.HouseBed;
import java.util.List;

public interface HouseBedMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_housebed
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    int deleteByPrimaryKey(Integer hbid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_housebed
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    int insert(HouseBed record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_housebed
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    HouseBed selectByPrimaryKey(Integer hbid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_housebed
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    List<HouseBed> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_housebed
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    int updateByPrimaryKey(HouseBed record);
}