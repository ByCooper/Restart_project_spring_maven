package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {
    private String title;
    private String body;
    private final UUID id = UUID.randomUUID();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title) && Objects.equals(body, article.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
    @Override
    public String getName() {
        return title;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public Article(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return title + '\n' + body;
    }

    @JsonIgnore
    @Override
    public String searchTerm() {
        return toString() + "_" + "ARTICLE";
    }

    @JsonIgnore
    @Override
    public String searchTypeContent() {
        return Article.class + "";
    }

    @Override
    public String getSearchName(Object o) {
        return Searchable.super.getSearchName(o);
    }
}
