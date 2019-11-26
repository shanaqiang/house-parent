package com.shana.house.mapper;

import com.shana.house.model.User;
import com.shana.house.qv.UserP;
import org.apache.ibatis.annotations.Insert;
import com.shana.house.rs.BackUserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    User selectByPrimaryKey(Integer uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    List<User> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    int updateByPrimaryKey(User record);

    @Select("select * from t_user where account=#{account} and password=#{password}")
    User selectByAccountAndPassword(String account,String password);
    @Select("select * from t_user where account=#{account}")
    User selectByAccount(String account);

    @Insert("insert into t_user(account,mobilephone,password) values(#{account},#{mobilephone},#{password})")
    int insertUser(UserP user);

    List<User> selectUser(BackUserVo vo) ;

    @Update("Update t_user set status = #{status} where uid in ${ids}" )
    void UpdateUserStatusByIds(BackUserVo vo) ;

    @Select("select * from t_user where account =#{account}")
    User sekectByAccount(String account);
    @Insert("update t_user set birthday=#{birthday},age=#{age} where account =#{account}")
    int changeAge(String account, Date birthday, Integer age);
    @Insert("update t_user set sex=#{sex} where account =#{account}")
    int changeSxe(String account, String sex);
    @Insert("update t_user set email=#{email} where account =#{account}")
    int changeEmail(String account, String email);
    @Insert("update t_user set mmobilephone=#{mobilephone} where account =#{account}")
    int changePhone(String account, String mobilephone);
    @Insert("update t_user set headimg=#{headimg} where account =#{account}")
    int changeImg(String account, String headimg);




}
