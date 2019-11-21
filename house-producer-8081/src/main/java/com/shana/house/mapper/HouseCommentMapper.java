package com.shana.house.mapper;

import com.shana.house.model.HouseComment;
import com.shana.house.qv.HouseCommentQv;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface HouseCommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_housecomment
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    int deleteByPrimaryKey(Integer hcid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_housecomment
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    int insert(HouseComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_housecomment
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    HouseComment selectByPrimaryKey(Integer hcid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_housecomment
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    List<HouseComment> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_housecomment
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    int updateByPrimaryKey(HouseComment record);

    List<HouseCommentQv> selectThreeComment(int hid);
}