package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {
    String searchTerm();

    String searchTypeContent();

    String getName();
    UUID getId();

    default String getSearchName(Object o) {
        return "Имя объекта -" + o.toString() + "- Тип объекта-" + o.getClass();
    }
}
