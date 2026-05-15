package com.workintech.library_system.entity;
import com.workintech.library_system.service.*;




public class LibraryManager implements Borrowable, Searchable {
    private InventoryService inventoryService;
    private LendingService lendingService;
    private AccountingService accountingService;
    private MemberService memberService;

    public LibraryManager(Library library) {
        this.inventoryService = new InventoryService(library);
        this.accountingService = new AccountingService();
        this.memberService = new MemberService(library);
        this.lendingService = new LendingService(inventoryService, accountingService, memberService);
    }

    public void addBook(Book book) {
        inventoryService.addBook(book);
    }

    public void removeBook(Long id) {
        inventoryService.removeBook(id);
    }

    @Override
    public void findBookByAuthor(String authorName) {
        inventoryService.findBookByAuthor(authorName);
    }

    public Book getBookById(Long id) {
        return inventoryService.findBook(id);
    }

    public void updateBookDetails(Long id, String newName, Author newAuthor, String newCategory) {
        inventoryService.updateBookDetails(id, newName, newAuthor, newCategory);
    }

    @Override
    public void searchBook(String title) {
        inventoryService.searchBook(title);
    }

    @Override
    public void lendBook(Long bookId, Long memberId) {
        lendingService.lendBook(bookId, memberId);
    }

    @Override
    public void returnBook(Long bookId, Long memberId) {
        lendingService.returnBook(bookId, memberId);
    }

    @Override
    public void listByCategory(String category) {
        inventoryService.listByCategory(category);
    }

    public void registerMember(Reader reader) {
        memberService.registerMember(reader);
    }

}
