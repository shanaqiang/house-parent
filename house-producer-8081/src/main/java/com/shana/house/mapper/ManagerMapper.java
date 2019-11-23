package com.shana.house.mapper;

import com.shana.house.model.Manager;
import com.shana.house.rs.ManagerVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ManagerMapper {
    @Select("select * from t_manager where mid = #{id}")
    Manager selectById(int mid) ;

    @Select("select * from t_manager")
    List<Manager> selectAll() ;

    List<Manager> selectManager(ManagerVo vo) ;

    @Update("update t_manager set status = #{status}, gender=#{gender}, tel = #{tel}, img = #{img} where mid = #{mid}")
    void update(Manager manager) ;

    @Insert("insert into t_manager values (null,#{mname},#{mpass},#{img},#{gender},#{tel},#{status},#{createdate},#{description})")
    void insert(Manager manager) ;

    void updateManager(Manager manager) ;

    @Update("Update t_manager set status = #{status} where mid in ${ids}" )
    void updatestatusbyids(ManagerVo vo);
}
