package com.qiuwuyu.web;

import com.qiuwuyu.pojo.Cart;
import com.qiuwuyu.pojo.Customer;
import com.qiuwuyu.pojo.Order;
import com.qiuwuyu.pojo.OrderItem;
import com.qiuwuyu.service.OrderService;
import com.qiuwuyu.service.impl.OrderServiceImpl;
import com.qiuwuyu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author paralog
 * @date 2021/6/20 15:20
 */
public class OrderServlet extends BaseServlet {

    OrderService orderService = new OrderServiceImpl();

    protected void creatOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        Customer user = (Customer) req.getSession().getAttribute("user");

        if (user == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        Integer userId = user.getId();
        String orderId = orderService.creatOrder(cart, userId);
        if (orderId == null){
            req.setAttribute("msg", "库存不够!");
            resp.sendRedirect(req.getContextPath()+"/pages/cart/cart.jsp");
            System.out.println("库存不够!");
            return;
        }
        req.getSession().setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }

    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
//        int orderStatus = WebUtils.parseInter(req.getParameter("orderStatus"), 0);
        List<OrderItem> orderItems = orderService.showOrderDetail(orderId);
        req.getSession().setAttribute("orderItems", orderItems);
        req.getSession().setAttribute("orderId", orderId);
//        req.getSession().setAttribute("orderStatus", orderStatus);
        resp.sendRedirect(req.getContextPath() + "/pages/order/order_item.jsp");
    }

    protected void showMyOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer user = (Customer) req.getSession().getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        int userId = user.getId();
        List<Order> orders = orderService.showMyOrders(userId);
        req.getSession().setAttribute("myOrders", orders);
        resp.sendRedirect(req.getContextPath() + "/pages/order/order.jsp");
    }

    protected void receiveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        orderService.receiveOrder();
        String orderId = req.getParameter("orderId");
        orderService.receiveOrder(orderId);
        showMyOrder(req,resp);
    }
}
