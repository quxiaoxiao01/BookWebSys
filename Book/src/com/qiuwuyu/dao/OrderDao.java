package com.qiuwuyu.dao;

import com.qiuwuyu.pojo.Order;
import com.qiuwuyu.pojo.Status;

import java.util.List;

/**
 * @author paralog
 * @date 2021/6/20 15:45
 */
public interface OrderDao {
    int saveOder(Order order);
    List<Order> queryAllOrders();
    void changeOrderStatus(String orderId , Integer status);
    List<Order> queryOrderByUserId(Integer userId);


}
