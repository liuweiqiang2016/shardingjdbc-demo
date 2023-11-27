package com.zdxlz.lwq.service;

import com.zdxlz.lwq.enity.Order;
import com.zdxlz.lwq.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    //插入默认数据源
    public void insertDB(){

        for (int i = 0; i < 5; i++) {
            Order order=new Order();
//            BigDecimal order_id=new BigDecimal(new Random().nextInt(999999));
//            order.setOrder_id(order_id);
            order.setPrice(new Random().nextInt(1000));
            order.setUser_id(new Random().nextInt(1000));
            order.setStatus("SUCCESS");
            order.setCreate_date(new Date());
            orderMapper.insert(order);
        }

    }


}
