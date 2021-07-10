package com.qiuwuyu.dao.impl;

import com.qiuwuyu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 * 编写BaseDao抽象类
 *
 * @author paralog
 * @date 2021/5/20 9:50
 */
public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();


    public int update(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * BeanHandler:表示把结果集中的一行数据，封装成一个对象，专门针对结果集中只有一行数据的情况
     *
     * @param type type的类型是T eg:Customer
     * @param sql  查询语句,中间有占位符
     * @param args 占位符够用对象数组中的对象一一特换
     * @param <T>  泛型T
     * @return T 返回值为T类型的实例 eg ： customer
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    //BeanListHandler:表示把结果集中的多行数据，封装成一个对象的集合，针对结果集中有多行数据。
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 将单个值封装、 例如select count（*），求内容的条数；
     * 执行返回一行一列的 sql 语句
     *
     * @param sql  执行的 sql 语句
     * @param args sql 对应的参数值
     * @return
     */
    public Object queryForSingleValue(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
