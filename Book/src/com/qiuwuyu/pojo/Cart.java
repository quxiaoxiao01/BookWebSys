package com.qiuwuyu.pojo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author paralog
 * @date 2021/6/18 11:08
 */
public class Cart {
    private Map<Integer, CartItem> items = new HashMap();

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void addItem(CartItem cartItem) {
        if (cartItem != null) {
            CartItem item = items.get(cartItem.getId());
            if (item != null) {
                item.setCount(item.getCount() + 1);
                //更新总金额
                item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
            } else {
                items.put(cartItem.getId(), cartItem);
            }
        }
    }

    public void deleteItem(Integer id) {
        items.remove(id);
    }

    public void clearItem() {
        items.clear();
    }

    public void updateCount(Integer id, Integer count) {
        CartItem cartItem = items.get(id);
        if (cartItem != null) {
            cartItem.setCount(count);
            //别忘了修改总金额
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }

    public Integer getTotalCount() {
        int totalCount = 0;
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "totalCount=" + getTotalCount() + " , totalPrice=" + getTotalPrice() + " , Cart{" +
                "items=" + items +
                '}' ;
    }
}
