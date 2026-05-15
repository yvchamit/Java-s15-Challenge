package com.workintech.library_system.entity;
import com.workintech.library_system.entity.details.Account;
import com.workintech.library_system.entity.details.ContactInfo;
import com.workintech.library_system.enums.UserRole;
import java.util.Date;




public class MemberRecord {
    private Long memberId;
    private UserRole type;
    private Date dateOfMembership;
    private int noBooksIssued;
    private int maxBookLimit;

    private Account account;
    private ContactInfo contact;

    public MemberRecord(Long memberId, UserRole type, int maxBookLimit) {
        this.memberId = memberId;
        this.type = type;
        this.maxBookLimit = maxBookLimit;
        this.noBooksIssued = 0;
        this.dateOfMembership = new Date();
        this.account = new Account(100.0);
    }

    public boolean isLimitReached() {
        return noBooksIssued >= maxBookLimit;
    }

    public void incBookIssued() {
        if (!isLimitReached()) noBooksIssued++;
    }

    public void decBookIssued() {
        if (noBooksIssued > 0) noBooksIssued--;
    }

    public void pay(double amount) {
        account.withdraw(amount);
    }

    public void refund(double amount) {
        account.deposit(amount);
    }

    public Account getAccount() {
        return account;
    }

    public void setContact(ContactInfo contact) {
        this.contact = contact;
    }

    public ContactInfo getContact() {
        return contact;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public Long getMemberId() {
        return memberId;
    }

    public double getBalance() {
        return this.account.getBalance();
    }

    @Override
    public String toString() {
        return "Üye No: " + memberId + " • " + account.toString();
    }
}