package com.workintech.library_system.entity;
import java.util.*;



public class Library {
    private Map<Long, Book> inventory;
    private Map<Long, Reader> members;

    public Library() {
        this.inventory = new HashMap<>();
        this.members = new HashMap<>();
    }

    public void addBook(Book book) {
        inventory.put(book.getBookID(), book);
    }

    public void registerMember(Reader reader) {
        members.put(reader.getId(), reader);
    }

    public Collection<Book> getInventory() {
        return inventory.values();
    }

    public Book getBookById(Long id) {
        return inventory.get(id);
    }

    public Reader getMemberById(Long id) {
        return members.get(id);
    }

    public void removeBookFromInventory(Long id) {
        inventory.remove(id);
    }
}
