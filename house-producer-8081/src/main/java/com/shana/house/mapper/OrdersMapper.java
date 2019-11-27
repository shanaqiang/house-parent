package com.shana.house.mapper;

import com.shana.house.model.Orders;
import com.shana.house.qv.OrderSearch;

import java.util.List;

public interface OrdersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_orders
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    int deleteByPrimaryKey(Integer oid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_orders
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    int insert(Orders record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_orders
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    Orders selectByPrimaryKey(Integer oid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_orders
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    List<Orders> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_orders
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    int updateByPrimaryKey(Orders record);

    OrderSearch selectByOid(String oid);
}
