package com.qiuwuyu.dao;

import com.qiuwuyu.pojo.Customer;

/**
 * @author paralog
 * @date 2021/5/21 14:36
 */
public interface CustomerDao {

    /**
     * 保存用户信息 注册时调用
     *
     * @return 返回影响的行数
     */
    public int saveCustomer(Customer customer);

    /**
     * 按照用户名查找用户对象 用于判断用户名是否重名
     *
     * @param username
     * @return
     */
    public Customer queryCustomerByName(String username);

    /**
     * 登录时使用 判断能否登录成功
     *
     * @return
     */
    public Customer queryCustomerByNameAndPassword(String username, String password);


    public void updateName(Integer id, String username);

    public void updatePassword(Integer id, String password);

    public void updateEmail(Integer id, String email);

}
