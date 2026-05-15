package com.workintech.library_system.entity;




public class StudyBooks extends Book {

    private String subject;

    public StudyBooks(Long bookID, String name, Author author, double price, String subject) {
        super(bookID, name, author, price);
        this.subject = subject;
    }

    @Override
    public void display() {
        System.out.println("Kitap Bilgileri");
        System.out.println(super.toString());
        System.out.println("Konu: " + subject + "\n");
    }

    @Override
    public String getCategory() {
        return this.subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
