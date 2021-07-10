package com.qiuwuyu.service;

import com.qiuwuyu.pojo.Book;
import com.qiuwuyu.pojo.Page;

import java.util.List;

/**
 * @author paralog
 * @date 2021/6/3 15:15
 */
public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Page page(int pageNo, int pageSize);

    Page pageByPrice(int pageNo, int pageSize, int min, int max);
}
