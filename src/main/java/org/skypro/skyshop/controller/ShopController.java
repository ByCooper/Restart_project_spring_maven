package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

@RestController
public class ShopController {

    private final StorageService storageService;
    private final SearchService searchService;
    private final BasketService basketService;

    public ShopController(StorageService storageService, SearchService searchService, BasketService basketService) {
        this.storageService = storageService;
        this.searchService = searchService;
        this.basketService = basketService;
    }

    /**
     * Отображение всех продуктов, которые содержатся интернет-магазине
     * @return
     */
    @GetMapping("/product")
    public Collection<Product> getAllProducts(){
        return storageService.getAllProduct();
    }

    /**
     * Отображение информационных статей
     * @return
     */
    @GetMapping("/article")
    public Collection<Article> getAllArticles(){
        return storageService.getAllArticles();
    }

    /**
     * Поиск по наименованию в интернет-магазине
     * @param pattern
     * @return
     */
    @GetMapping("/search")
    public Collection<SearchResult> search(@RequestParam("pattern") String pattern){
        return searchService.search(pattern);
    }

    /**
     * Добавление наименования в продуктовую корзину пользователя
     * @param id
     * @return
     */
    @GetMapping("/getbasket/{id}")
    public String addProduct(@PathVariable("id") UUID id){
       basketService.addProductInBasket(id);
        return "Продукт успешно добавлен";
    }

    /**
     * Отображение содержимого корзины пользователя
     * @return
     */
    @GetMapping("/basket")
    public UserBasket getUserBasket(){
        return basketService.getUserBasket();
    }
}
