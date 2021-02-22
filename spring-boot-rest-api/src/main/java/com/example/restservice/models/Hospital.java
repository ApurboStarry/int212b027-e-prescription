package com.example.restservice.models;

import com.example.restservice.utils.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection = "hospitals")
public class Hospital {
    @Id
    private String id;

    private String hospitalName;
    private String branchName;
    private Address address;
    private String email;
    private String contactNumber;

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    private String createdOn;

    public Hospital(String hospitalName, String branchName, Address address, String email, String contactNumber) {
        this.hospitalName = hospitalName;
        this.branchName = branchName;
        this.address = address;
        this.email = email;
        this.contactNumber = contactNumber;

        Date dNow = new Date( );
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        createdOn = simpleDateFormat.format(dNow);
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id='" + id + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", branchName='" + branchName + '\'' +
                ", address=" + address +
                ", email='" + email + '\'' +
                ", createdOn='" + createdOn + '\'' +
                '}';
    }
}
