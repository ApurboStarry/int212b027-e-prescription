package com.example.restservice.models;

import com.example.restservice.utils.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection = "doctors")
public class Doctor {
    @Id
    private String doctorId;

    private String hospitalId;
    private String doctorName;
    private String speciality;
    private Address address;
    private String about;

    private String createdOn;

    public Doctor(String hospitalId, String doctorName, String speciality, Address address, String about) {
        this.hospitalId = hospitalId;
        this.doctorName = doctorName;
        this.speciality = speciality;
        this.address = address;
        this.about = about;

        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        createdOn = simpleDateFormat.format(now);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + doctorId + '\'' +
                ", hospitalId='" + hospitalId + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", speciality='" + speciality + '\'' +
                ", address=" + address +
                ", about='" + about + '\'' +
                ", createdOn='" + createdOn + '\'' +
                '}';
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}

