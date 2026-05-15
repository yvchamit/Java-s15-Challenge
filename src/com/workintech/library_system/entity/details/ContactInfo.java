package com.workintech.library_system.entity.details;

public class ContactInfo {
    private String address;
    private String phoneNo;

    public ContactInfo(String address, String phoneNo) {
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
}
