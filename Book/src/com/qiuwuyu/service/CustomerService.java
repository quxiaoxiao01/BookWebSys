package com.qiuwuyu.service;

import com.qiuwuyu.pojo.Customer;

import java.nio.file.attribute.UserDefinedFileAttributeView;

/**
 * 网页提供给用户的服务
 * 既然是功能，那么就必须直观，比如existCustomerByUsername 的结果就得是boolean类型的
 *
 * @author paralog
 * @date 2021/5/21 15:09
 */
public interface CustomerService {
    /**
     * 既然网页已经准备开始调用注册了（调用前肯定判断过），那么就直接和数据库交互，进行注册即可
     *
     * @param customer
     */
    public void registerCustomer(Customer customer);

    //public Customer login(String username , String password);
    public Customer login(Customer customer);

    public boolean existCustomerByUsername(String username);

//    public Customer getCustomerInfo(String username);

    public void updateName(Integer id, String username);
    public void updatePassword(Integer id, String password);
    public void updateEmail(Integer id, String email);
}
