package com.qiuwuyu.dao.impl;

import com.qiuwuyu.dao.CustomerDao;
import com.qiuwuyu.pojo.Customer;

/**
 * @author paralog
 * @date 2021/5/21 14:40
 */
public class CustomerDaoImpl extends BaseDao implements CustomerDao {

    @Override
    public int saveCustomer(Customer customer) {
        String sql = "insert into user_info(`username`,`password`,`email`) values(?,?,?)";
        return update(sql, customer.getUsername(), customer.getPassword(), customer.getEmail());
    }

    @Override
    public Customer queryCustomerByName(String username) {
        String sql = "select `id`,`username`,`password`,`email` from user_info where `username` = ?";
        return queryForOne(Customer.class, sql, username);
    }

    @Override
    public Customer queryCustomerByNameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from user_info where `username` = ? and password = ?";
        return queryForOne(Customer.class, sql, username, password);
    }

    @Override
    public void updateName(Integer id, String username) {
        String sql = "update user_info set `username` = ? where id = ?";
        int update = update(sql, username, id);
        System.out.println(update);
    }

    @Override
    public void updatePassword(Integer id, String password) {
        String sql = "update user_info set `password` = ? where id = ?";
        update(sql, password, id);
    }

    @Override
    public void updateEmail(Integer id, String email) {
        String sql = "update user_info set `email` = ? where id = ?";
        update(sql, email, id);
    }


}
