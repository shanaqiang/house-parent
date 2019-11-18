package com.shana.house.mapper;

import com.shana.house.model.HouseRule;
import java.util.List;

public interface HouseRuleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_houserule
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    int deleteByPrimaryKey(Integer hrid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_houserule
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    int insert(HouseRule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_houserule
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    HouseRule selectByPrimaryKey(Integer hrid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_houserule
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    List<HouseRule> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_houserule
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    int updateByPrimaryKey(HouseRule record);
}