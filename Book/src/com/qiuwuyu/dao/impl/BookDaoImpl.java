package com.qiuwuyu.dao.impl;

import com.qiuwuyu.dao.BookDao;
import com.qiuwuyu.pojo.Book;

import java.util.List;

/**
 * @author paralog
 * @date 2021/6/3 14:16
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name`,`price`,`author`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBook(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
//        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
        String sql = "update t_book set `name` = ?,`price` = ?,`author` = ?,`sales` = ?,`stock` = ?,`img_path` = ? where id = ?";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` imgPath from t_book where id = ?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` imgPath from t_book ";
        return queryForList(Book.class, sql);
    }

    @Override
    public int pageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> pageBooks(int begin, int pageSize) {
        String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` imgPath from t_book limit ?,?";
        return queryForList(Book.class, sql, begin, pageSize);
    }

    @Override
    public int pageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql, min, max);
        return count.intValue();
    }

    @Override
    public List<Book> pageBooksByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` imgPath from t_book where price between ? and ? " +
                "order by price limit ?,?";
        return queryForList(Book.class, sql, min, max, begin, pageSize);
    }


}
