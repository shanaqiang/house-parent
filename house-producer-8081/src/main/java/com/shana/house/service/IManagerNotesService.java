package com.shana.house.service;

import com.shana.house.model.ManagerNotes;

import java.util.List;

public interface IManagerNotesService {
    List<ManagerNotes> findAllByMid(int mid) ;

    void add(ManagerNotes mn) ;

    void remove(int nid) ;

    void motify(ManagerNotes mn) ;
}
