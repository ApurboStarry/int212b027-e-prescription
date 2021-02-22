package com.example.restservice.models;

import com.example.restservice.utils.Diet;
import com.example.restservice.utils.Medicine;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Document(collection = "prescriptions")
public class Prescription {
    @Id
    private String prescriptionId;

    private String registrationId; // id of patient
    private String doctorId; // id of doctor
    private String bloodPressure;
    private String pulseRate;
    private float weight;
    private List<String> allergies;
    private List<String> disabilities;
    private List<Medicine> medicines;
    private List<Diet> diets;
    private String patientHistory;
    private String followUpDoctorId;

    private String createdOn;
    private String modifiedOn;

    public Prescription(String registrationId, String doctorId, String bloodPressure, String pulseRate, float weight, List<String> allergies, List<String> disabilities, List<Medicine> medicines, List<Diet> diets, String patientHistory, String followUpDoctorId) {
        this.registrationId = registrationId;
        this.doctorId = doctorId;
        this.bloodPressure = bloodPressure;
        this.pulseRate = pulseRate;
        this.weight = weight;
        this.allergies = allergies;
        this.disabilities = disabilities;
        this.medicines = medicines;
        this.diets = diets;
        this.patientHistory = patientHistory;
        this.followUpDoctorId = followUpDoctorId;

        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        createdOn = simpleDateFormat.format(now);
        modifiedOn = simpleDateFormat.format(now);
    }

    public void assign(Prescription p) {
        this.registrationId = p.registrationId;
        this.doctorId = p.doctorId;
        this.bloodPressure = p.bloodPressure;
        this.pulseRate = p.pulseRate;
        this.weight = p.weight;
        this.allergies = p.allergies;
        this.disabilities = p.disabilities;
        this.medicines = p.medicines;
        this.diets = p.diets;
        this.patientHistory = p.patientHistory;
        this.followUpDoctorId = p.followUpDoctorId;

        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        modifiedOn = simpleDateFormat.format(now);
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionId='" + prescriptionId + '\'' +
                ", registrationId='" + registrationId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", bloodPressure='" + bloodPressure + '\'' +
                ", pulseRate='" + pulseRate + '\'' +
                ", weight=" + weight +
                ", allergies=" + allergies +
                ", disabilities=" + disabilities +
                ", medicines=" + medicines +
                ", diets=" + diets +
                ", patientHistory='" + patientHistory + '\'' +
                ", followUpDoctorId='" + followUpDoctorId + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", modifiedOn='" + modifiedOn + '\'' +
                '}';
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(String pulseRate) {
        this.pulseRate = pulseRate;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public List<String> getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(List<String> disabilities) {
        this.disabilities = disabilities;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public List<Diet> getDiets() {
        return diets;
    }

    public void setDiets(List<Diet> diets) {
        this.diets = diets;
    }

    public String getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(String patientHistory) {
        this.patientHistory = patientHistory;
    }

    public String getFollowUpDoctorId() {
        return followUpDoctorId;
    }

    public void setFollowUpDoctorId(String followUpDoctorId) {
        this.followUpDoctorId = followUpDoctorId;
    }
}
