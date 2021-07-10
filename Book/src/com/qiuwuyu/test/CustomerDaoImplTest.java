package com.qiuwuyu.test;

import com.qiuwuyu.dao.impl.CustomerDaoImpl;
import com.qiuwuyu.pojo.Customer;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author paralog
 * @date 2021/5/21 14:58
 */
class CustomerDaoImplTest {
    CustomerDaoImpl customerDao = new CustomerDaoImpl();

    @org.junit.jupiter.api.Test
    void saveCustomer() {
        int i = customerDao.saveCustomer(new Customer(null, "屈小小", "aq123456", "147415970@.com"));
        System.out.println(i);
    }

    @org.junit.jupiter.api.Test
    void queryCustomerByName() {
        Customer customer = customerDao.queryCustomerByName("屈小小");
        System.out.println(customer);
    }

    @org.junit.jupiter.api.Test
    void queryCustomerByNameAndPassword() {
        Customer customer = customerDao.queryCustomerByNameAndPassword("屈小小8","aq123456");
        System.out.println(customer);
    }

    @org.junit.jupiter.api.Test
    void updateUsername(){
        customerDao.updateName(1,"test111111");
    }

    @org.junit.jupiter.api.Test
    void updatePassword(){
        customerDao.updatePassword(1,"151322");
    }
}