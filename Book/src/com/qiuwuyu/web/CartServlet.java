package com.qiuwuyu.web;

import com.qiuwuyu.pojo.Book;
import com.qiuwuyu.pojo.Cart;
import com.qiuwuyu.pojo.CartItem;
import com.qiuwuyu.service.BookService;
import com.qiuwuyu.service.impl.BookServiceImpl;
import com.qiuwuyu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author paralog
 * @date 2021/6/18 15:16
 */
public class CartServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInter(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);

        req.getSession().setAttribute("lastBookName",book.getName());
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
//        System.out.println("请求头为" + req.getHeader("Referer"));
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInter(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
            //回到之前的那个网页
            resp.sendRedirect(req.getHeader("Referer"));
//            req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req,resp);
        }
    }


    protected void clearItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            req.getSession().removeAttribute("cart");
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void updateItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInter(req.getParameter("id"), 0);
        int count = WebUtils.parseInter(req.getParameter("count"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateCount(id, count);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
