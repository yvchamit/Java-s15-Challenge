package com.workintech.library_system.service;

public interface Searchable {
    void searchBook(String title);

    void findBookByAuthor(String authorName);

    void listByCategory(String category);
}
