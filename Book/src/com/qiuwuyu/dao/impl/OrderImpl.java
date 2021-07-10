package com.qiuwuyu.dao.impl;

import com.qiuwuyu.dao.OrderDao;
import com.qiuwuyu.pojo.Order;
import com.qiuwuyu.pojo.Status;
import org.apache.commons.dbutils.QueryRunner;

import java.util.Date;
import java.util.List;

/**
 * @author paralog
 * @date 2021/6/20 15:46
 */
public class OrderImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`)values(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreatTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }

    @Override
    public List<Order> queryAllOrders() {
        String sql = "SELECT `order_id` orderId,`create_time` creatTime,`price`,`status`,`user_id` userId FROM t_order";
//        String sql = "select `order_id` ,`create_time`,`price`,`status`,`user_id`  from t_order";
//        String sql = "select `order_id` orderId,`create_time` creatTime,`price`,`status`,`user_id` userId from t_order";
        return queryForList(Order.class, sql);
    }

    @Override
    public void changeOrderStatus(String orderId, Integer status) {
        String sql = "update t_order set `status` = ? where `order_id` = ?";
        update(sql,status,orderId);
    }

    @Override
    public List<Order> queryOrderByUserId(Integer userId) {
        String sql = "select `order_id` orderId,`create_time` creatTime,`price`,`status`,`user_id` userId from t_order where `user_id` = ?";
        return queryForList(Order.class, sql, userId);
    }
}
