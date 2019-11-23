package com.shana.house.qv;

import com.shana.house.model.House;
import lombok.Data;

import java.util.Date;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author asus
 * @create 2019/11/20
 * @since 1.0.0
 */
@Data
public class HouseQv extends House {

    private Integer uid;
    private String account;
    private String sex;
    private String email;
    private String mobilephone;
    private String selfintroduction;
    private String headimg;
}
