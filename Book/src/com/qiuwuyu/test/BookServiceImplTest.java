package com.qiuwuyu.test;

import com.qiuwuyu.pojo.Book;
import com.qiuwuyu.pojo.Page;
import com.qiuwuyu.service.BookService;
import com.qiuwuyu.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author paralog
 * @date 2021/6/3 15:20
 */
class BookServiceImplTest {
    BookService bookService = new BookServiceImpl();
    Book book1 = new Book(null,"当下的力量",new BigDecimal(20.04),"埃克哈特",1000,1,null);
    @Test
    void addBook() {
        bookService.addBook(book1);
    }

    @Test
    void deleteBookById() {
        bookService.deleteBookById(26);
    }

    @Test
    void updateBook() {
        book1.setId(25);
        bookService.updateBook(book1);
    }

    @Test
    void queryBookById() {
        System.out.println(bookService.queryBookById(25));
    }

    @Test
    void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    void page(){
        System.out.println(bookService.page(1, Page.SIZE));
    }
}