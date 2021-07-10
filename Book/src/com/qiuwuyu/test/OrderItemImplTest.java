package com.qiuwuyu.test;

import com.qiuwuyu.dao.OrderItemDao;
import com.qiuwuyu.dao.impl.OrderItemImpl;
import com.qiuwuyu.pojo.Order;
import com.qiuwuyu.pojo.OrderItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author paralog
 * @date 2021/6/21 17:32
 */
class OrderItemImplTest {
    OrderItemDao orderItem = new OrderItemImpl();
    @Test
    void saveOrderItem() {
        orderItem.saveOrderItem(new OrderItem(null,"Java从入门到放弃",1,new BigDecimal(150),new BigDecimal(150),"12345678910"));
    }

    @Test
    void queryOrderItemByOrderId() {
        System.out.println(orderItem.queryOrderItemByOrderId("12345678910"));
    }
}