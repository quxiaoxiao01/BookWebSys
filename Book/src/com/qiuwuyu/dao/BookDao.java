package com.qiuwuyu.dao;

import com.qiuwuyu.pojo.Book;

import java.util.List;

/**
 * @author paralog
 * @date 2021/6/3 14:17
 */
public interface BookDao {
    public int addBook(Book book);

    public int deleteBook(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public int pageTotalCount();

    public List<Book> pageBooks(int begin,int pageSize);

    public List<Book> pageBooksByPrice(int begin, int pageSize, int min, int max);

    public int pageTotalCountByPrice(int min, int max);
}
