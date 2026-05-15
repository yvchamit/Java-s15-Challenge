package com.workintech.library_system.service;
import com.workintech.library_system.entity.*;
import com.workintech.library_system.enums.BookStatus;


public class InventoryService implements Searchable {
    private Library library;

    public InventoryService(Library library) {
        this.library = library;
    }

    /*public Book findBook(Long id) {
        for (Book b : library.getInventory()) {
            if (b.getBookID().equals(id)) return b;
        }
        return null;
    }*/

    public Book findBook(Long id) {
        return library.getBookById(id);
    }

    @Override
    public void searchBook(String title) {
        boolean found = false;
        for (Book boo : library.getInventory()) {
            if (boo.getName().equalsIgnoreCase(title)) {
                boo.display();
                found = true;
            }
        }
        if (!found) System.out.println("Kitap bulunamadı: " + title);
    }

    public boolean removeBook(Long id) {
        Book book = findBook(id);
        if (book != null && book.getStatus() == BookStatus.AVAILABLE) {
            library.removeBookFromInventory(id);
            System.out.println(id + " ID'li kitap sistemden kalıcı olarak silindi.");
            return true;
        }
        System.out.println("Hata: Silinmek istenen kitap bulunamadı.");
        return false;
    }

    @Override
    public void listByCategory(String category) {
        System.out.println(category + " Kategorisi Listeleniyor");
        boolean found = false;
        for (Book boo : library.getInventory()) {
            if (boo.getCategory().equalsIgnoreCase(category)) {
                boo.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println(category + " kategorisinde kitap bulunamadı.");
        }
    }

    @Override
    public void findBookByAuthor(String authorName) {
        System.out.println(authorName + " Yazarına Ait Eserler");
        boolean found = false;
        for (Book b : library.getInventory()) {
            if (b.getAuthor() != null && b.getAuthor().getName().equalsIgnoreCase(authorName)) {
                b.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println(authorName + " için sistemde bir eser bulunamadı.");
        }
    }

    public void updateBookDetails(Long id, String newName, Author newAuthor, String newCategory) {
        Book b = findBook(id);
        if (b != null) {
            b.setName(newName);
            b.setAuthor(newAuthor);
            if (b instanceof StudyBooks) {
                ((StudyBooks) b).setSubject(newCategory);
            }
            System.out.println(id + " ID'li kitap başarıyla güncellendi.");
        }
    }

    public void addBook(Book newBook) {
        if (findBook(newBook.getBookID()) != null) {
            System.out.println("Dikkat! " + newBook.getBookID() +
                    " ID'li bir kitap zaten sistemde mevcut! (" + newBook.getName() + ")");
            return;
        }

        library.addBook(newBook);

        if (newBook.getAuthor() != null) {
            newBook.getAuthor().addBook(newBook);
        }

        System.out.println(newBook.getName() + " Sisteme eklendi!");
    }
}