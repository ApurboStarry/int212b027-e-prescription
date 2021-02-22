package com.example.restservice.utils;

public class Address {
    private String street;
    private String postOffice;
    private String upazilla;
    private String district;
    private String division;

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", postOffice='" + postOffice + '\'' +
                ", upazilla='" + upazilla + '\'' +
                ", district='" + district + '\'' +
                ", division='" + division + '\'' +
                '}';
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    public String getUpazilla() {
        return upazilla;
    }

    public void setUpazilla(String upazilla) {
        this.upazilla = upazilla;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public Address(String street, String postOffice, String upazilla, String district, String division) {
        this.street = street;
        this.postOffice = postOffice;
        this.upazilla = upazilla;
        this.district = district;
        this.division = division;
    }
}
