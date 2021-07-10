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

/**
 * @author paralog
 * @date 2021/6/8 8:27
 */
public class ClientBookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInter(req.getParameter("pageNo"), 1);
//        int pageSize = Page.SIZE;
        int pageSize = WebUtils.parseInter(req.getParameter("pageSize"), Page.SIZE);
        Page page = bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInter(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInter(req.getParameter("pageSize"), Page.SIZE);
        int min = WebUtils.parseInter(req.getParameter("min"), 0);
        int max = WebUtils.parseInter(req.getParameter("max"), Integer.MAX_VALUE);
        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        // 如果有最小价格的参数,追加到分页条的地址参数中
        if (req.getParameter("min") != null) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        // 如果有最大价格的参数,追加到分页条的地址参数中
        if (req.getParameter("max") != null) {
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());
        //3 保存Page对象到Request域中
        req.setAttribute("page",page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}
