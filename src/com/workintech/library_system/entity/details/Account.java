package com.workintech.library_system.entity.details;

public class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
        if (balance < 0) {
            System.out.println("Dikkat! Bakiye eksiye düştü! Borç: " + Math.abs(balance));
        }
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println(amount + " TL yüklendi. Güncel bakiye: " + balance + " TL");
    }

    public boolean canBorrow() {
        return balance >= 0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return balance >= 0 ? "Bakiye: " + balance + " TL" : " Ödenmesi Gereken: " + Math.abs(balance) + " TL";
    }
}
