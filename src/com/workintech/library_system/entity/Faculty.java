package com.workintech.library_system.entity;


import com.workintech.library_system.enums.UserRole;

public class Faculty extends Reader {
    private MemberRecord memberRecord;

    public Faculty(Long id, String name) {
        super(id, name, new MemberRecord(id, UserRole.FACULTY, 10));
    }

    @Override
    public UserRole whoyouare() {
        return UserRole.FACULTY;
    }

    @Override
    public String toString() {
        return getMemberRecord().toString();
    }
}
