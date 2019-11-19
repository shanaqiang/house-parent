package com.shana.house.model;

import lombok.*;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author EDZ
 * @create 2019/11/18
 * @since 1.0.0
 */
@Data
public class ManagerNotes {
    private int nid ;
    private String title ;
    private int status ;    //1 已完成 true  2 未完成  false
    private int mid ;
}
