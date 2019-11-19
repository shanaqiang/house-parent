package com.shana.house.mapper;

import com.shana.house.model.ManagerNotes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author EDZ
 * @create 2019/11/18
 * @since 1.0.0
 */
@Mapper
public interface ManagerNotesMapper {

    List<ManagerNotes> selectAllByMid(int mid) ;

    void insert(ManagerNotes mn) ;

    void delete(int nid) ;

    void update(ManagerNotes mn) ;
}
