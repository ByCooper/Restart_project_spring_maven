package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BasketService {

    private final StorageService storageService;
    private final ProductBasket productBasket;


    public BasketService(StorageService storageService, ProductBasket productBasket) {
        this.storageService = storageService;
        this.productBasket = productBasket;
    }

    /**
     * Добавление продукта по UUID в продуктовую корзину
     * @param id
     */
    public void addProductInBasket(UUID id){
        if(storageService.getProductById(id).isEmpty()){
            throw new IllegalArgumentException();
        } else{
            productBasket.addProduct(id);
        }
    }

    /**
     * Получение содержимого продуктовой корзины пользователя
     * @return экземпляр класса UserBasket
     */
    public UserBasket getUserBasket(){
        return new UserBasket(productBasket.getBasket().keySet().stream()
                .map(integer -> new BasketItem(storageService.getProductById(integer).get(), productBasket.getBasket().get(integer)))
                .toList());
    }
}