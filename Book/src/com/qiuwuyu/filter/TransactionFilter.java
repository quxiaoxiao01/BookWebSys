package com.qiuwuyu.filter;

import com.qiuwuyu.utils.JdbcUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author paralog
 * @date 2021/7/8 10:20
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            JdbcUtils.commitAndCloseConnection();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtils.rollbackAndCloseConnection();
            throw new RuntimeException(e);
        }

    }


    @Override
    public void destroy() {

    }
}
