package com.workintech.library_system.service;
import com.workintech.library_system.entity.*;
import com.workintech.library_system.enums.BookStatus;


public class LendingService {

    private InventoryService inventoryService;
    private AccountingService accountingService;
    private MemberService memberService;

    public LendingService(InventoryService inventoryService, AccountingService accountingService, MemberService memberService) {
        this.inventoryService = inventoryService;
        this.accountingService = accountingService;
        this.memberService = memberService;
    }


    public void lendBook(Librarian staff, Reader reader, Book book) {
        MemberRecord record = reader.getMemberRecord();

        if (book.getStatus() != BookStatus.AVAILABLE) {
            System.out.println("Dikkat! Kitap şu an kütüphanede değil.");
        } else if (record.getNoBooksIssued() >= record.getMaxBookLimit()) {
            System.out.println("Dikkat! Bu üye 5 kitaptan fazlasını ödünç alamaz!");
        } else if (!accountingService.isBalanceSufficient(record)) {
            System.out.println("Dikkat! Üyenin ödenmemiş borcu var. Başka bir kitabı ödünç alamaz!");
        } else {
            book.setStatus(BookStatus.ISSUED);
            record.incBookIssued();
            reader.getBorrowedBooks().add(book);

            System.out.println(reader.getName() + ", " + book.getName() + " isimli kitabı ödünç aldı. (İşlemi yapan: " + staff.getName() + ")");
        }
    }

    public void lendBook(Long bookId, Long memberId) {
        Book book = inventoryService.findBook(bookId);
        Reader reader = memberService.findMember(memberId);

        Librarian staff = new Librarian(99L, "Aslan Amca", "STAFF_001", "123456");

        if (book != null && reader != null) {
            lendBook(staff, reader, book);
        } else {
            System.out.println("Dikkat! Kayıt bulunamadı.");
        }
    }

    public void returnBook(Long bookId, Long memberId) {
        Book book = inventoryService.findBook(bookId);
        Reader reader = memberService.findMember(memberId);

        if (book != null && reader != null) {
            returnBook(reader, book);
        } else {
            System.out.println("Dikkat! İade işlemi için kayıt eksik.");
        }
    }

    public void returnBook(Reader reader, Book book) {
        if (reader.getBorrowedBooks().contains(book)) {
            MemberRecord record = reader.getMemberRecord();

            record.decBookIssued();
            reader.getBorrowedBooks().remove(book);
            book.setStatus(BookStatus.AVAILABLE);

            System.out.println(book.getName() + " başarıyla iade alındı.");
        } else {
            System.out.println("Dikkat! Bu kitap bu kullanıcının ödünç aldığı kitaplar listesinde bulunamadı!");
        }
    }

}