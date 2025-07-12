package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class StorageService {
    private final Map<UUID, Product> mapProduct;
    private final Map<UUID, Article> mapArticle;

    public StorageService(Map<UUID, Product> mapProduct, Map<UUID, Article> mapArticle) {
        this.mapProduct = productMap();
        this.mapArticle = articleMap();
    }

    public Map<UUID, Product> getMapProduct() {
        return mapProduct;
    }

    public Map<UUID, Article> getArticleMap() {
        return mapArticle;
    }

    public Collection<Product> getAllProduct() {
        return getMapProduct().values().stream().toList();
    }

    public Collection<Article> getAllArticles() {
        return getArticleMap().values().stream().toList();
    }

    private Map<UUID, Product> productMap() {
        Map<UUID, Product> map = new HashMap<>();
        Product vahid = new SimpleProduct("Chease", 10);
        Product tnin = new SimpleProduct("Meet", 1000);
        Product tlyati = new FixPriceProduct("Cola Burger");
        Product arba = new FixPriceProduct("Cola");
        Product hamsi = new DiscountedProduct("Shashlik", 100, 15);
        Product sitta = new DiscountedProduct("Ovocsh", 70, 5);
        map.put(vahid.getId(), vahid);
        map.put(tnin.getId(), tnin);
        map.put(tlyati.getId(), tlyati);
        map.put(arba.getId(), arba);
        map.put(hamsi.getId(), hamsi);
        map.put(sitta.getId(), sitta);
        return map;
    }

    private Map<UUID, Article> articleMap() {
        Map<UUID, Article> map = new HashMap<>();
        Article post = new Article("Gazirovka - top", "Coca-Cola is vkusno otchen, and I realy loved drink Coca-Cola");
        Article post1 = new Article("Eda vkusno", "Lublu Cola Chahohbili and Shashlik");
        map.put(post.getId(), post);
        map.put(post1.getId(), post1);
        return map;
    }

    public Collection<Searchable> getAllElements() {
        return Stream.concat(productMap().values().stream(), articleMap().values().stream()).toList();
    }
}
