package com.shana.house.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shana.house.mapper.ManagerMapper;
import com.shana.house.model.Manager;
import com.shana.house.model.User;
import com.shana.house.rs.ManagerVo;
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
 * @create 2019/11/21
 * @since 1.0.0
 */
@Service
@Transactional
public class ManagerServiceImpl implements IManagerService {
    @Autowired
    private ManagerMapper managerMapper ;


    @Override
    public Manager findById(int mid) {
        return managerMapper.selectById(mid);
    }

    @Override
    public ResponseResult findAll(int index, int size) {
        PageHelper.startPage(index,size);
        List<Manager> managers = managerMapper.selectAll();
        PageInfo<Manager> info = new PageInfo<>(managers) ;
        return new ResponseResult().add("pageinfo",info);
    }

    @Override
    public ResponseResult findManager(ManagerVo vo) {
        PageHelper.startPage(vo.getPageIndex(),vo.getPageSize()) ;
        List<Manager> managers = managerMapper.selectManager(vo) ;
        PageInfo<Manager> info = new PageInfo<>(managers) ;
        return new ResponseResult().add("pageinfo",info);
    }


    @Override
    public void add(Manager manager) {
        managerMapper.insert(manager);
    }

    @Override
    public void motify(Manager manager) {
        managerMapper.update(manager);
    }

    @Override
    public ResponseResult motifyManager(ManagerVo vo) {
        if(vo.getMid()==null) {
            return new ResponseResult("500","未找到mid") ;
        }
        Manager manager1 = managerMapper.selectById(vo.getMid());
        if(manager1==null) {
            return new ResponseResult("500","未找到该用户") ;
        }
        if(!vo.getOldpass().equals(manager1.getMpass())) {
            return new ResponseResult("500","密码错误") ;
        }
        Manager manager = new Manager() ;
        manager.setMid(vo.getMid());
        manager.setMpass(vo.getMpass());
        managerMapper.updateManager(manager);
        return new ResponseResult("200","修改成功");
    }

    @Override
    public void motifystatusbyids(ManagerVo vo) {
        managerMapper.updatestatusbyids(vo) ;
    }
}
