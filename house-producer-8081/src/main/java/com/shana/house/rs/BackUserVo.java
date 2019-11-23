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
public class BackUserVo {
    private String account ;
    private String sex ;
    private Integer status ;
    private Integer pageIndex ;
    private Integer pageSize ;
    private String ids ;
}
