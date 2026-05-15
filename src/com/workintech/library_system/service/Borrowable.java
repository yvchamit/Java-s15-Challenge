package com.workintech.library_system.service;

public interface Borrowable {
    void lendBook(Long bookId, Long memberId);

    void returnBook(Long bookId, Long memberId);
}
