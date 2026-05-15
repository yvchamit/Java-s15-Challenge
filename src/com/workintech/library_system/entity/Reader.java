package com.workintech.library_system.entity;
import java.util.HashSet;
import java.util.Set;




public abstract class Reader extends Person {
    private Set<Book> borrowedBooks;
    private MemberRecord memberRecord;

    public Reader(Long id, String name, MemberRecord memberRecord) {
        super(id, name);
        this.borrowedBooks = new HashSet<>();
        this.memberRecord = memberRecord;
    }

    public Set<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public MemberRecord getMemberRecord() {
        return memberRecord;
    }


}
