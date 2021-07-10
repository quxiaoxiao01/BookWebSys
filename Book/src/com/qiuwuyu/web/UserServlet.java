package com.qiuwuyu.web;

import com.google.gson.Gson;
import com.qiuwuyu.pojo.Customer;
import com.qiuwuyu.service.impl.CustomerServiceImpl;
import com.qiuwuyu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author paralog
 * @date 2021/6/1 20:22
 */
public class UserServlet extends BaseServlet {

    CustomerServiceImpl customerService = new CustomerServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        Customer login = customerService.login(new Customer(null, username, password, null));
        Customer customer = WebUtils.copyParamToBean(req.getParameterMap(), new Customer());
        Customer login = customerService.login(customer);
        if (login != null) {
            req.getSession().setAttribute("user", login);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        } else {
            req.setAttribute("msg", "用户名或者密码错误");
            req.setAttribute("username", customer.getUsername());
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }


    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codeKey = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        if (code != null && code.equals(codeKey)) {
            boolean b = customerService.existCustomerByUsername(username);
            if (b) {
                req.setAttribute("msg", "该用户已存在!");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                Customer customer = WebUtils.copyParamToBean(req.getParameterMap(), new Customer());
                customerService.registerCustomer(customer);
                req.getSession().setAttribute("user", customer);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msg", "验证码错误!");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、销毁Session中用户登录的信息（或者销毁Session）
        req.getSession().invalidate();
//        2、重定向到首页（或登录页面）。
        resp.sendRedirect(req.getContextPath());
    }

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean existUsername = customerService.existCustomerByUsername(username);
        Map<String, Object> map = new HashMap<>();
        map.put("existUsername", existUsername);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        resp.getWriter().write(json);
    }

    protected void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
