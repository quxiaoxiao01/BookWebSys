package com.qiuwuyu.test;

import com.qiuwuyu.pojo.Customer;
import com.qiuwuyu.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author paralog
 * @date 2021/5/21 15:34
 */
class CustomerServiceImplTest {
    CustomerServiceImpl customerService = new CustomerServiceImpl();

    @Test
    void registerCustomer() {
        customerService.registerCustomer(new Customer(null, "屈小小", "aq123456", "147415970@.com"));
        customerService.registerCustomer(new Customer(null, "屈小小2", "aq123456", "147415970@.com"));
    }

    @Test
    void login() {
        System.out.println(customerService.login(new Customer(null, "屈小小", "aq123456", null)));
    }

    @Test
    void existCustomerByUsername() {
        boolean existCustomerByUsername = customerService.existCustomerByUsername("屈小小");
        if (existCustomerByUsername){
            System.out.println("已存在");
        }else{
            System.out.println("未存在");
        }
    }
}