package com.zdxlz.lwq.enity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

@TableName("t_order")
public class Order {
    @TableId
    private BigDecimal order_id;
    @TableField("price")
    private int price;
    @TableField("user_id")
    private int user_id;
    @TableField("status")
    private String status;
    @TableField("create_date")
    private Date create_date;

    public BigDecimal getOrder_id() {
        return order_id;
    }

    public void setOrder_id(BigDecimal order_id) {
        this.order_id = order_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}
