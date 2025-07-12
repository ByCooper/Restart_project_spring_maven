package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product{
    private int basicPrice;
    private int discount;

    public DiscountedProduct(String name, int basicPrice, int discount) {
        super(name);
        if(basicPrice <= 0){
            throw new IllegalArgumentException();
        } else {
            this.basicPrice = basicPrice;
        }
        if(discount >= 100 && discount <= 0){
            throw new IllegalArgumentException();
        } else {
            this.discount = discount;
        }
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return basicPrice - ((basicPrice * discount) / 100);
    }

    @Override
    public String toString() {
        return getName() +
                '\n' + getPrice() + " RUB (sale " + discount +
                " %)";
    }
}
