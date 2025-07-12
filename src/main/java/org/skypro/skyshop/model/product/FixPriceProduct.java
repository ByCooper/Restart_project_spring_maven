package org.skypro.skyshop.model.product;

public class FixPriceProduct extends Product{
    private static final int FIXED_FOR_PRICE = 100;
    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return FIXED_FOR_PRICE;
    }

    @Override
    public String toString() {
        return getName() + '\n' + " Фиксированная цена " + FIXED_FOR_PRICE + " RUB";
    }
}
