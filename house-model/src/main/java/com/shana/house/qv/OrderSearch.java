package com.shana.house.qv;

import com.shana.house.model.House;
import com.shana.house.model.HouseRule;
import com.shana.house.model.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderSearch {
    private Orders orders;
    private House house;
    private HouseRule houseRule;

}
