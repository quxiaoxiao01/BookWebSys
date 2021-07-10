package com.qiuwuyu.service.impl;

import com.qiuwuyu.dao.BookDao;
import com.qiuwuyu.dao.impl.BookDaoImpl;
import com.qiuwuyu.dao.impl.OrderImpl;
import com.qiuwuyu.dao.impl.OrderItemImpl;
import com.qiuwuyu.pojo.*;
import com.qiuwuyu.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author paralog
 * @date 2021/6/20 15:44
 */
public class OrderServiceImpl implements OrderService {
    private OrderImpl orderDao = new OrderImpl();
    private OrderItemImpl orderItemDao = new OrderItemImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String creatOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem cartItem = entry.getValue();
            Book book = bookDao.queryBookById(cartItem.getId());
            if (book.getStock() - cartItem.getCount() < 0) {
                //阻止这次操作
                return null;
            }
        }
        orderDao.saveOder(order);
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem cartItem = entry.getValue();
            Book book = bookDao.queryBookById(cartItem.getId());
            orderItemDao.saveOrderItem(new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId));
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);
        }

        cart.clearItem();
        return orderId;
    }

    @Override
    public List<Order> showAllOrders() {
        return orderDao.queryAllOrders();
    }

    @Override
    public void sendOrder(String orderId) {
        orderDao.changeOrderStatus(orderId, 1);
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) {
        return orderItemDao.queryOrderItemByOrderId(orderId);
    }

    @Override
    public List<Order> showMyOrders(Integer userId) {
        return orderDao.queryOrderByUserId(userId);
    }

    @Override
    public void receiveOrder(String orderId) {
        orderDao.changeOrderStatus(orderId, 2);
    }
}
