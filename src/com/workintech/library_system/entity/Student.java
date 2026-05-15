package com.workintech.library_system.entity;
import com.workintech.library_system.enums.UserRole;




public class Student extends Reader {

    private MemberRecord memberRecord;

    public Student(Long id, String name) {
        super(id, name, new MemberRecord(id, UserRole.STUDENT, 5));
    }

    @Override
    public UserRole whoyouare() {
        return UserRole.STUDENT;
    }

    @Override
    public String toString() {
        return getMemberRecord().toString();
    }
}
