package com.workintech.library_system.entity;
import com.workintech.library_system.enums.UserRole;
import com.workintech.library_system.service.AccountingService;
import com.workintech.library_system.service.InventoryService;
import com.workintech.library_system.service.LendingService;
import com.workintech.library_system.service.MemberService;




public class Librarian extends Person {

    private String employeeId;
    private String password;

    public Librarian(Long id, String name, String employeeId, String password) {
        super(id, name);
        this.employeeId = employeeId;
        this.password = password;
    }

    public void searchBook(InventoryService inventory, String title) {
        inventory.searchBook(title);
    }

    public boolean verifyMember(MemberService memberService, Long memberId) {
        return memberService.findMember(memberId) != null;
    }

    public void issueBook(LendingService lending, Reader reader, Book book) {
        lending.lendBook(this, reader, book);
    }

    public void createBill(AccountingService accounting, MemberRecord record) {
        if (accounting.isBalanceSufficient(record)) {
            accounting.charge(record);
            System.out.println("Fatura oluşturuldu ve tahsil edildi. Görevli: " + getName());
        } else {
            System.out.println("Bakiye yetersiz!");
        }
    }

    public void returnBook(LendingService lending, Reader reader, Book book) {
        lending.returnBook(reader, book);
    }

    @Override
    public UserRole whoyouare() {
        return UserRole.LIBRARIAN;
    }
}
