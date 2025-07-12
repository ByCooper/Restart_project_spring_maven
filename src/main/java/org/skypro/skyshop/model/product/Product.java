package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    private final String name;
    private final UUID id = UUID.randomUUID();

    public Product(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Имя не может быть пустым");
        } else {
            this.name = name;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public abstract boolean isSpecial();

    public abstract int getPrice();

    @JsonIgnore
    @Override
    public String searchTerm() {
        return getName() + "_" + "PRODUCT" ;
    }

    @JsonIgnore
    @Override
    public String searchTypeContent() {
        return Product.class + "";
    }

    @Override
    public String getSearchName(Object o) {
        return Searchable.super.getSearchName(o);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}
