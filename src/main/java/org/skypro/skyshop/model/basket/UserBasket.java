package org.skypro.skyshop.model.basket;

import java.util.List;

public class UserBasket {
    private final List<BasketItem> list;
    private final int total;

    public UserBasket(List<BasketItem> list) {
        this.list = list;
        this.total = list.stream().mapToInt(e -> (e.getProduct().getPrice() * e.getCount())).sum();
    }

    public List<BasketItem> getList() {
        return list;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "UserBasket{" +
                "list=" + list +
                ", total=" + total +
                '}';
    }
}