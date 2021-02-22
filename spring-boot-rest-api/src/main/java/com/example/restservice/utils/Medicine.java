package com.example.restservice.utils;

public class Medicine {
    private String drugName;
    private String unit;
    private String dosage;

    public Medicine(String drugName, String unit, String dosage) {
        this.drugName = drugName;
        this.unit = unit;
        this.dosage = dosage;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "drugName='" + drugName + '\'' +
                ", unit='" + unit + '\'' +
                ", dosage='" + dosage + '\'' +
                '}';
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
}
