package com.shana.house.model;

import lombok.Data;

import java.util.Date;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author xiana
 * @create 2019/11/26
 * @since 1.0.0
 */
@Data
public class HouseAddress {
    private int haid;
    private int hid;
    private String province;
    private String city;
    private String yard;
    private Date createdate;
    private String loc;
    private int status;

    @Override
    public String toString() {
        return "HouseAddress{" +
                "haid=" + haid +
                ", hid=" + hid +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", yard='" + yard + '\'' +
                ", createDate=" + createdate +
                ", loc='" + loc + '\'' +
                ", status=" + status +
                '}';
    }
}

