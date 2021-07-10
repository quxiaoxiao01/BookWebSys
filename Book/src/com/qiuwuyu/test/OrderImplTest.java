package com.qiuwuyu.test;

import com.qiuwuyu.dao.impl.OrderImpl;
import com.qiuwuyu.pojo.Order;
import com.qiuwuyu.pojo.Status;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author paralog
 * @date 2021/6/20 17:42
 */
class OrderImplTest {
    OrderImpl order = new OrderImpl();

    @Test
    void saveOder() {
        order.saveOder(new Order("12345678910", new Date(), new BigDecimal(80), 0, 1));
        order.saveOder(new Order("123456789101", new Date(), new BigDecimal(90), 0, 1));
        order.saveOder(new Order("123456789102", new Date(), new BigDecimal(880), 0, 2));
    }

    @Test
    void queryAllOrders() {
        List<Order> orders = order.queryAllOrders();
        for (Order order1 : orders) {
            System.out.println(order1);
        }
    }

    @Test
    void changeOrderStatus() {
        order.changeOrderStatus("12345678910",1);
        List<Order> orders = order.queryAllOrders();
        for (Order order1 : orders) {
            System.out.println(order1);
        }
    }

    @Test
    void queryOrderByUserId() {
        List<Order> orders = order.queryOrderByUserId(1);
        for (Order order1 : orders) {
            System.out.println(order1);
        }
    }
}