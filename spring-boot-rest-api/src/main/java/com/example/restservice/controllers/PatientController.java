package com.example.restservice.controllers;

import com.example.restservice.models.Doctor;
import com.example.restservice.models.Patient;
import com.example.restservice.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        try {
            List<Patient> patientList = new ArrayList<>();
            patientRepository.findAll().forEach(patientList::add);

            return new ResponseEntity<>(patientList, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/patients/id/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") String id) {
        try {
            Optional<Patient> patientData = patientRepository.findById(id);

            if(patientData.isPresent()) {
                return new ResponseEntity<>(patientData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/patients/name/{name}")
    public ResponseEntity<Patient> getPatientByName(@PathVariable String name) {
        Optional<Patient> patientData = patientRepository.findPatientByName(name);

        if(patientData.isPresent()) {
            return new ResponseEntity<>(patientData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/patients/namedob/{name}/{dob}")
    public ResponseEntity<Patient> getPatientByNameAndDOB(@PathVariable String name, @PathVariable String dob) {
        Optional<Patient> patientData = patientRepository.findPatientByNameAndDateOfBirth(name, dob);

        if(patientData.isPresent()) {
            return new ResponseEntity<>(patientData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/patients")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        try {
            Patient _patient = patientRepository.save(patient);
            return new ResponseEntity<>(_patient, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient> updateDoctor(@PathVariable("id") String id, @RequestBody Patient patient) {
        Optional<Patient> patientData = patientRepository.findById(id);

        if(patientData.isPresent()) {
            Patient _patient = patientData.get();
            _patient.setDoctorId(patient.getDoctorId());
            _patient.setHospitalId(patient.getHospitalId());
            _patient.setUpi(patient.getUpi());
            _patient.setName(patient.getName());
            _patient.setDateOfBirth(patient.getDateOfBirth());
            _patient.setAge(patient.getAge());
            _patient.setGender(patient.getGender());
            _patient.setOccupation(patient.getOccupation());
            _patient.setHealthInsuranceNumber(patient.getHealthInsuranceNumber());
            _patient.setHealthcareProvider(patient.getHealthcareProvider());
            _patient.setAddress(patient.getAddress());
            _patient.setContactNumber(patient.getContactNumber());

            return new ResponseEntity<>(patientRepository.save(_patient), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<HttpStatus> deleteDoctor(@PathVariable("id") String id) {
        try {
            patientRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/patients")
    public ResponseEntity<HttpStatus> deleteAllDoctors() {
        try {
            patientRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
