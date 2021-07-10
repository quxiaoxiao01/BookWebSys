package com.qiuwuyu.service;

import com.qiuwuyu.pojo.Cart;
import com.qiuwuyu.pojo.Order;
import com.qiuwuyu.pojo.OrderItem;

import java.util.List;

/**
 * @author paralog
 * @date 2021/6/20 15:39
 */
public interface OrderService {
    String creatOrder(Cart cart,Integer userId);
    List<Order> showAllOrders();
    void sendOrder(String orderId);
    List<OrderItem> showOrderDetail(String orderId);
    List<Order> showMyOrders(Integer userId);
    void receiveOrder(String orderId);
}
