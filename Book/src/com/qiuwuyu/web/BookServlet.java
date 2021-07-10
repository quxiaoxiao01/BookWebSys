package com.qiuwuyu.web;

import com.qiuwuyu.pojo.Book;
import com.qiuwuyu.pojo.Page;
import com.qiuwuyu.service.BookService;
import com.qiuwuyu.service.impl.BookServiceImpl;
import com.qiuwuyu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author paralog
 * @date 2021/6/3 15:52
 */
public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.addBook(book);
//        req.getRequestDispatcher("/manger/bookServlet?action=list").forward(req,resp);
        resp.sendRedirect(req.getContextPath() + "/manger/bookServlet?action=page");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        bookService.deleteBookById(WebUtils.parseInter(req.getParameter("id"), 0));
        resp.sendRedirect(req.getContextPath() + "/manger/bookServlet?action=page");
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath() + "/manger/bookServlet?action=page");
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInter(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInter(req.getParameter("pageNo"), 1);
        int pageSize = Page.SIZE;
        Page page = bookService.page(pageNo, pageSize);
        page.setUrl("manger/bookServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
//        resp.sendRedirect(req.getContextPath() + "/manger/bookServlet?action=page");  你这是写循环呢????
    }
}
