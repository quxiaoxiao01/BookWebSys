package com.qiuwuyu.web;


import com.qiuwuyu.pojo.Customer;
import com.qiuwuyu.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author paralog
 * @date 2021/5/21 15:52
 */
public class RegisterServlet extends HttpServlet {

    CustomerServiceImpl customerService = new CustomerServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        if ("paralog".equals(code)) {
            boolean b = customerService.existCustomerByUsername(username);
            if (b) {
//                System.out.println("该用户已存在");
                req.setAttribute("msg","该用户已存在!");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                Customer customer = new Customer(null, username, password, email);
                customerService.registerCustomer(customer);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msg","验证码错误!");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
//            System.out.println("验证码:" + code + "错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
