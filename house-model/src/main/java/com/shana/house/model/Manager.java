package com.shana.house.model;

import lombok.Data;

import java.util.Date;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author EDZ
 * @create 2019/11/21
 * @since 1.0.0
 */
@Data
public class Manager {
    private Integer mid ;
    private String mname ;
    private String mpass ;
    private String img ;
    private String gender ;
    private String tel ;
    private Integer status ;
    private Date createdate ;
    private String description ;
}
