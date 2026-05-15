package com.workintech.library_system.entity;



public class Magazines extends Book{

    private int issue;

    public Magazines(Long bookID, String name, Author publisher, double price, int issue) {
        super(bookID, name, publisher, price);
        this.issue = issue;
    }

    @Override
    public void display() {
        System.out.println("Dergi Bilgileri");
        System.out.println(super.toString());
        System.out.println("Sayı: " + issue);
    }

    @Override
    public String getCategory() {
        return "Süreli Yayın";
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }
}
