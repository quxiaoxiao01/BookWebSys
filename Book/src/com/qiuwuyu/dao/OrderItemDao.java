package com.qiuwuyu.dao;

import com.qiuwuyu.pojo.OrderItem;

import java.util.List;

/**
 * @author paralog
 * @date 2021/6/20 15:46
 */
public interface OrderItemDao {
    int saveOrderItem(OrderItem orderItem);
    List<OrderItem> queryOrderItemByOrderId(String orderId);
}
