package com.zdxlz.lwq.controller;

import com.zdxlz.lwq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class MyController {
    @Autowired
    private OrderService orderService;
   @GetMapping("test")
    public String helloWorld(){
        return "hello world:"+new Date();
    }

    @GetMapping("insertDB")
    public String insertDB(){
       orderService.insertDB();
       return "插入数据库:"+new Date();
    }

}
