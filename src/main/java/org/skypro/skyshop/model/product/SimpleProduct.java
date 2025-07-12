package org.skypro.skyshop.model.product;

public class SimpleProduct extends Product{
    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if(price <= 0){
            throw new IllegalArgumentException();
        } else {
            this.price = price;
        }
    }


    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() +
                '\n' + price +
                " RUB";
    }
}
