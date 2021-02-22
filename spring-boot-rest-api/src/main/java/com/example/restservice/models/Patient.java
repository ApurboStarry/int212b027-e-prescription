package com.example.restservice.models;

import com.example.restservice.utils.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection = "patients")
public class Patient {
    @Id
    private String registrationId;

    private String doctorId;
    private String hospitalId;
    private String upi;
    private String name;
    private String dateOfBirth;
    private int age;
    private String gender;
    private String occupation;
    private String healthInsuranceNumber;
    private String healthcareProvider;
    private Address address;
    private String contactNumber;

    private String createdOn;

    public Patient(String doctorId, String hospitalId, String upi, String name, String dateOfBirth, int age, String gender, String occupation, String healthInsuranceNumber, String healthcareProvider, Address address, String contactNumber) {
        this.doctorId = doctorId;
        this.hospitalId = hospitalId;
        this.upi = upi;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.healthInsuranceNumber = healthInsuranceNumber;
        this.healthcareProvider = healthcareProvider;
        this.address = address;
        this.contactNumber = contactNumber;

        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        createdOn = simpleDateFormat.format(now);
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getUpi() {
        return upi;
    }

    public void setUpi(String upi) {
        this.upi = upi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getHealthInsuranceNumber() {
        return healthInsuranceNumber;
    }

    public void setHealthInsuranceNumber(String healthInsuranceNumber) {
        this.healthInsuranceNumber = healthInsuranceNumber;
    }

    public String getHealthcareProvider() {
        return healthcareProvider;
    }

    public void setHealthcareProvider(String healthcareProvider) {
        this.healthcareProvider = healthcareProvider;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "registrationId='" + registrationId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", hospitalId='" + hospitalId + '\'' +
                ", upi='" + upi + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", occupation='" + occupation + '\'' +
                ", healthInsuranceNumber='" + healthInsuranceNumber + '\'' +
                ", healthcareProvider='" + healthcareProvider + '\'' +
                ", address=" + address +
                ", contactNumber='" + contactNumber + '\'' +
                ", createdOn='" + createdOn + '\'' +
                '}';
    }
}
