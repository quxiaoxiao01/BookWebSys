package com.qiuwuyu.service.impl;

import com.qiuwuyu.dao.BookDao;
import com.qiuwuyu.dao.impl.BaseDao;
import com.qiuwuyu.dao.impl.BookDaoImpl;
import com.qiuwuyu.pojo.Book;
import com.qiuwuyu.pojo.Page;
import com.qiuwuyu.service.BookService;

import java.util.List;

/**
 * @author paralog
 * @date 2021/6/3 15:16
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        int totalCount = bookDao.pageTotalCount();
        page.setPageTotalCount(totalCount);
        int pageTotal = totalCount / Page.SIZE;
        if (totalCount % Page.SIZE != 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDao.pageBooks(begin, pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();
        int totalCount = bookDao.pageTotalCountByPrice(min,max);
        page.setPageTotalCount(totalCount);
        int pageTotal = totalCount / Page.SIZE;
        if (totalCount % Page.SIZE != 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDao.pageBooksByPrice(begin, pageSize,min,max);
        page.setItems(items);
        return page;
    }

}
