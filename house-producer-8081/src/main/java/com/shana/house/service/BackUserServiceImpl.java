package com.shana.house.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shana.house.mapper.UserMapper;
import com.shana.house.model.User;
import com.shana.house.rs.BackUserVo;
import com.shana.house.rs.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author EDZ
 * @create 2019/11/19
 * @since 1.0.0
 */
@Service
@Transactional
public class BackUserServiceImpl implements IBackUserService {
    @Autowired
    private UserMapper userMapper ;

    @Override
    public ResponseResult findAll(int index, int size) {
        PageHelper.startPage(index,size);
        List<User> users = userMapper.selectAll();
        PageInfo<User> info = new PageInfo<>(users) ;
        return new ResponseResult().add("pageinfo",info);
    }

    @Override
    public void update(User u) {
        userMapper.updateByPrimaryKey(u) ;
    }

    @Override
    public ResponseResult findUser(BackUserVo vo) {
        PageHelper.startPage(vo.getPageIndex(),vo.getPageSize()) ;
        List<User> users = userMapper.selectUser(vo) ;
        PageInfo<User> info = new PageInfo<>(users) ;
        return new ResponseResult().add("pageinfo",info) ;
    }

    @Override
    public void updateUserStatusByIds(BackUserVo vo) {
        userMapper.UpdateUserStatusByIds(vo);
    }
}
