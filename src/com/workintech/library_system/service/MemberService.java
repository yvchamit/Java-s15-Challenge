package com.workintech.library_system.service;

import com.workintech.library_system.entity.Library;
import com.workintech.library_system.entity.Reader;

public class MemberService {
    private Library library;

    public MemberService(Library library) {
        this.library = library;
    }

    /*public Reader findMember(Long id) {
        for (Reader member : library.getMembers()) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null;
    }*/

    public Reader findMember(Long id) {
        return library.getMemberById(id);
    }


    public void registerMember(Reader newReader) {
        if (findMember(newReader.getId()) != null) {
            System.out.println("Dikkat! " + newReader.getId() + " ID'li üye zaten kayıtlı!");
        } else {
            library.registerMember(newReader);
            System.out.println("Üye başarıyla kaydedildi: " + newReader.getName());
        }
    }
}
