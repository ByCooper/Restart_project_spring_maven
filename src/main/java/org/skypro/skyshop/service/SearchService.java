package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    /**
     * Поиск наименования по имени в пространстве интернет-магазина среди продуктов и статей
     * @param s
     * @return Коллекция элементов, которые содержат в имени и теле(статья) искомое значение
     */
    public Collection<SearchResult> search(String s){
        return storageService.getAllElements().stream()
                .filter(e -> e.toString().contains(s))
                .map(e -> new SearchResult(e.getId().toString(), e.getName(), e.searchTypeContent()))
                .toList();
    }
}
