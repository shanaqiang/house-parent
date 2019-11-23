package com.shana.house.rs;

import lombok.Data;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author EDZ
 * @create 2019/11/21
 * @since 1.0.0
 */
@Data
public class ManagerVo {
    private Integer mid ;
    private String oldpass ;
    private String mpass ;


    private String mname ;
    private String gender ;
    private Integer status ;
    private Integer pageIndex ;
    private Integer pageSize ;
    private String ids ;
}
