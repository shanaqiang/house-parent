package com.shana.house.service;

import com.netflix.discovery.converters.Auto;
import com.shana.house.mapper.ManagerNotesMapper;
import com.shana.house.model.ManagerNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author EDZ
 * @create 2019/11/18
 * @since 1.0.0
 */
@Service
@Transactional
public class ManagerNotesServiceImpl implements IManagerNotesService {
    @Autowired
    private ManagerNotesMapper managerNotesMapper ;
    @Override
    public List<ManagerNotes> findAllByMid(int mid) {
        return managerNotesMapper.selectAllByMid(mid);
    }

    @Override
    public void add(ManagerNotes mn) {
        managerNotesMapper.insert(mn);
    }

    @Override
    public void remove(int nid) {
        managerNotesMapper.delete(nid);
    }

    @Override
    public void motify(ManagerNotes mn) {
        managerNotesMapper.update(mn);
    }
}
