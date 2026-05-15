package com.workintech.library_system.entity;
import com.workintech.library_system.enums.UserRole;
import java.util.HashSet;
import java.util.Set;

public class Author extends Person {

    private Set<Book> books;

    public Author(Long id, String name) {
        super(id, name);
        this.books = new HashSet<>();
    }

    @Override
    public UserRole whoyouare() {
        return UserRole.AUTHOR;
    }

    public void addBook(Book book) {
        if (book == null || books.contains(book)) return;

        this.books.add(book);

        if (book.getAuthor() != this) {
            book.setAuthor(this);
        }
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Author: " + getName();
    }


}
