package com.qiuwuyu.test;

import com.qiuwuyu.pojo.Cart;
import com.qiuwuyu.pojo.CartItem;
import com.qiuwuyu.pojo.Order;
import com.qiuwuyu.pojo.OrderItem;
import com.qiuwuyu.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author paralog
 * @date 2021/6/21 18:44
 */
class OrderServiceImplTest {
    OrderServiceImpl orderService = new OrderServiceImpl();

    @Test
    void creatOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java 从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java 从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2, " 数据结构与算法", 1, new BigDecimal(100),new BigDecimal(100)));
        orderService.creatOrder(cart,1);
    }

    @Test
    void showAllOrders() {
        List<Order> orders = orderService.showAllOrders();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    void sendOrder() {
        orderService.sendOrder("16242723696861");
    }

    @Test
    void showOrderDetail() {
//        OrderItem orderItem = orderService.showOrderDetail("16242723696861");
//        System.out.println(orderItem);
        List<OrderItem> orderItems = orderService.showOrderDetail("16242723696861");
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }
    }

    @Test
    void showMyOrders() {
        List<Order> orders = orderService.showMyOrders(1);
        for (Order order : orders) {
            System.out.println(order);

        }
    }

    @Test
    void receiveOrder() {
        orderService.receiveOrder("16242723696861");

    }
}