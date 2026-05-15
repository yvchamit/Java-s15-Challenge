package com.workintech.library_system.service;
import com.workintech.library_system.entity.MemberRecord;

public class AccountingService {
    private final double FEE = 10.0;

    public boolean isBalanceSufficient(MemberRecord record) {
        return record.getBalance() >= FEE;
    }

    public void charge(MemberRecord record) {
        record.pay(FEE);
    }

    public void refund(MemberRecord record) {
        record.refund(FEE);
    }

    public double getFee() { return FEE; }
}