package com.qiuwuyu.test;

import com.qiuwuyu.dao.BookDao;
import com.qiuwuyu.dao.impl.BaseDao;
import com.qiuwuyu.dao.impl.BookDaoImpl;
import com.qiuwuyu.pojo.Book;
import com.qiuwuyu.pojo.Page;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author paralog
 * @date 2021/6/3 14:50
 */
class BookDaoImplTest {
    BookDao bookDao = new BookDaoImpl();

    @Test
    void addBook() {
        Book book = new Book(null, "神经衰弱的根治法", new BigDecimal(10.01), "森田正马", 98, 100, null);
        int i = bookDao.addBook(book);
        System.out.println(i);
    }

    @Test
    void deleteBook() {
        System.out.println(bookDao.deleteBook(22));
        System.out.println(bookDao.deleteBook(23));
        System.out.println(bookDao.deleteBook(24));
    }

    @Test
    void updateBook() {
        Book book2 = new Book(25, "堂吉诃德", new BigDecimal(10.01), "塞万提斯", 98, 100, null);
        bookDao.updateBook(book2);
    }

    @Test
    void queryBookById() {
        System.out.println(bookDao.queryBookById(15).toString());
    }

    @Test
    void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook.toString());
        }
    }

    @Test
    void pageTotalCount(){
        System.out.println(bookDao.pageTotalCount());
    }
    @Test
    void pageBooks(){
        List<Book> books = bookDao.pageBooks(8, Page.SIZE);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}