package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@Component
@SessionScope
public class ProductBasket {
    private final Map<UUID, Integer> basket;

    public ProductBasket(Map<UUID, Integer> basket) {
        this.basket = basket;
    }

    /**
     * Добавление информации по продукту, сохраняется id продукта и количество продуктов
     * @param id
     */
    public void addProduct(UUID id) {
        if (basket.containsKey(id)) {
            Integer value = basket.get(id) + 1;
            basket.put(id, value);

        } else {
            basket.put(id, 1);
        }
    }

    /**
     * Метод для получения информации по элементам, id и количество одинаковых объектов
     * @return Мапу с запретом на модификацию
     */
    public Map<UUID, Integer> getBasket() {
        return Collections.unmodifiableMap(basket);
    }
}