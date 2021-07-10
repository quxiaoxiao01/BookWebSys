package com.qiuwuyu.test;

import com.qiuwuyu.pojo.Cart;
import com.qiuwuyu.pojo.CartItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author paralog
 * @date 2021/6/18 14:39
 */
class CartTest {

    Cart cart = new Cart();

    @Test
    void addItem() {
        cart.addItem(new CartItem(1, "Java从入门到入土", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1, "Java从入门到入土", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "数据结构", 1, new BigDecimal(5.01), new BigDecimal(5.01)));

        System.out.println(cart);
    }

    @Test
    void deleteItem() {
        cart.addItem(new CartItem(1, "Java从入门到入土", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1, "Java从入门到入土", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "数据结构", 1, new BigDecimal(5.01), new BigDecimal(5.01)));

        cart.deleteItem(2);
        System.out.println(cart);
    }

    @Test
    void clearItem() {
        cart.addItem(new CartItem(1, "Java从入门到入土", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1, "Java从入门到入土", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "数据结构", 1, new BigDecimal(5.01), new BigDecimal(5.01)));
        cart.clearItem();
        System.out.println(cart);

    }

    @Test
    void updateCount() {
        cart.addItem(new CartItem(1, "Java从入门到入土", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1, "Java从入门到入土", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "数据结构", 1, new BigDecimal(5.01), new BigDecimal(5.01)));

        cart.updateCount(1,5);
        System.out.println(cart);

    }
}