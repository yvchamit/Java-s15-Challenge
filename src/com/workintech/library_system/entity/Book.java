package com.workintech.library_system.entity;
import com.workintech.library_system.enums.BookStatus;
import java.time.LocalDate;
import java.util.Objects;



public abstract class Book {
    private Long bookID;
    private Author author;
    private String name;
    private double price;
    private BookStatus status;
    private String edition;
    private LocalDate dateOfPurchase;

    public Book(Long bookID, String name, Author author, double price) {
        this.bookID = bookID;
        this.name = name;
        this.author = author;
        this.price = price;
        this.dateOfPurchase= LocalDate.now();
        this.status = BookStatus.AVAILABLE;
    }

    public Book(Long bookID, String name, Author author, double price, LocalDate dateOfPurchase) {
        this.bookID = bookID;
        this.name = name;
        this.author = author;
        this.price = price;
        this.dateOfPurchase = dateOfPurchase;
        this.status = BookStatus.AVAILABLE;
    }

    public void display() {
        System.out.println(this.toString());
    }

    public String getName() { return name; }

    public BookStatus getStatus() { return status; }

    public Long getBookID() { return bookID; }

    public Author getAuthor() { return author; }

    public double getPrice() { return price; }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Kitap --> ID= " + bookID + ", İsim= " + name + ", Yazar= " + author.getName() + ", Durum= " + status;
    }

    public abstract String getCategory();

    public void setAuthor(Author author) {
        this.author = author;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookID, book.bookID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bookID);
    }
}
