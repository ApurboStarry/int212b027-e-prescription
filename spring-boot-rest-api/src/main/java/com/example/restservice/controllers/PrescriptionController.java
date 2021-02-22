package com.example.restservice.controllers;

import com.example.restservice.models.Patient;
import com.example.restservice.models.Prescription;
import com.example.restservice.repositories.PatientRepository;
import com.example.restservice.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PrescriptionController {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/prescriptions")
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        try {
            List<Prescription> prescriptionList = new ArrayList<>();
            prescriptionRepository.findAll().forEach(prescriptionList::add);

            return new ResponseEntity<>(prescriptionList, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/prescriptions/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable String id) {
        try {
            Optional<Prescription> prescriptionData = prescriptionRepository.findById(id);

            if(prescriptionData.isPresent()) {
                return new ResponseEntity<>(prescriptionData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/prescriptions/patient/{patientId}")
    public ResponseEntity<Prescription> getPrescriptionByPatientId(@PathVariable String patientId) {
        List<Prescription> prescriptionData = prescriptionRepository.findPrescriptionByRegistrationId(patientId);

        try {

            if(prescriptionData.size() > 0) {
                return new ResponseEntity<>(prescriptionData.get(0), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/prescriptions/patient/{name}/{dob}")
    public ResponseEntity<Prescription> getPrescriptionByNameAndDOB(@PathVariable String name, @PathVariable String dob) {
        try {
            Optional<Patient> patientData = patientRepository.findPatientByNameAndDateOfBirth(name, dob);

            if(!patientData.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            List<Prescription> prescriptionData = prescriptionRepository.findPrescriptionByRegistrationId(patientData.get().getRegistrationId());
            if(prescriptionData.size() > 0) {
                return new ResponseEntity<>(prescriptionData.get(0), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/prescriptions")
    public ResponseEntity<Prescription> addPrescription(@RequestBody Prescription prescription) {
        try {
            Prescription _prescription = prescriptionRepository.save(prescription);
            return new ResponseEntity<>(_prescription, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/prescriptions/{id}")
    public ResponseEntity<Prescription> updatePrescription(@PathVariable String id, @RequestBody Prescription prescription) {
        Optional<Prescription> prescriptionData = prescriptionRepository.findById(id);

        if(prescriptionData.isPresent()) {
            Prescription _prescription = prescriptionData.get();
            _prescription.assign(prescription);

            return new ResponseEntity<>(prescriptionRepository.save(_prescription), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/prescriptions/{id}")
    public ResponseEntity<HttpStatus> deletePrescription(@PathVariable String id) {
        try {
            prescriptionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/prescriptions")
    public ResponseEntity<HttpStatus> deleteAllPrescriptions() {
        try {
            prescriptionRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}















