package com.qiuwuyu.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author paralog
 * @date 2021/6/20 15:12
 */
public class Order {
    private String orderId;
    private Date creatTime;
    private BigDecimal price;
    private Integer status = 0;
    private Integer userId;

    public Order(){

    }

    public Order(String orderId, Date creatTime, BigDecimal price, Integer status, Integer userId) {
        this.orderId = orderId;
        this.creatTime = creatTime;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", creatTime=" + creatTime +
                ", price=" + price +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
