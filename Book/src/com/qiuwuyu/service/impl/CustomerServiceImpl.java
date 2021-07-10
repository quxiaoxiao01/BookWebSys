package com.qiuwuyu.service.impl;

import com.qiuwuyu.dao.impl.CustomerDaoImpl;
import com.qiuwuyu.pojo.Customer;
import com.qiuwuyu.service.CustomerService;

/**
 * @author paralog
 * @date 2021/5/21 15:14
 */
public class CustomerServiceImpl implements CustomerService {
    CustomerDaoImpl customerDao = new CustomerDaoImpl();

    @Override
    public void registerCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    public Customer login(Customer customer) {
        return customerDao.queryCustomerByNameAndPassword(customer.getUsername(), customer.getPassword());
    }

    @Override
    public boolean existCustomerByUsername(String username) {
        Customer customer = customerDao.queryCustomerByName(username);
        if (customer != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void updateName(Integer id, String username) {
        customerDao.updateName(id, username);
    }

    @Override
    public void updatePassword(Integer id, String password) {
        customerDao.updatePassword(id, password);
    }

    @Override
    public void updateEmail(Integer id, String email) {
        customerDao.updateEmail(id, email);
    }


//    @Override
//    public Customer getCustomerInfo(String username) {
//        return customerDao.queryCustomerByName(username);
//    }
}
