package com.example.restservice.controllers;

import com.example.restservice.models.Doctor;
import com.example.restservice.models.Hospital;
import com.example.restservice.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        try {
            List<Doctor> doctorList = new ArrayList<>();
            doctorRepository.findAll().forEach(doctorList::add);

            return new ResponseEntity<>(doctorList, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/doctors/id/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") String id) {
        Optional<Doctor> doctorData = doctorRepository.findById(id);

        if(doctorData.isPresent()) {
            return new ResponseEntity<>(doctorData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/doctors/name/{name}")
    public ResponseEntity<Doctor> getDoctorByName(@PathVariable String name) {
        Optional<Doctor> doctorData = doctorRepository.findDoctorByDoctorName(name);

        if(doctorData.isPresent()) {
            return new ResponseEntity<>(doctorData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/doctors")
    public ResponseEntity<Doctor> createTutorial(@RequestBody Doctor doctor) {
        try {
            Doctor _doctor = doctorRepository.save(doctor);
            return new ResponseEntity<>(_doctor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/doctors/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") String id, @RequestBody Doctor doctor) {
        Optional<Doctor> doctorData = doctorRepository.findById(id);

        if(doctorData.isPresent()) {
            Doctor _doctor = doctorData.get();
            _doctor.setHospitalId(doctor.getHospitalId());
            _doctor.setDoctorName(doctor.getDoctorName());
            _doctor.setSpeciality(doctor.getSpeciality());
            _doctor.setAddress(doctor.getAddress());
            _doctor.setAbout(doctor.getAbout());

            return new ResponseEntity<>(doctorRepository.save(_doctor), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/doctors/{id}")
    public ResponseEntity<HttpStatus> deleteDoctor(@PathVariable("id") String id) {
        try {
            doctorRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/doctors")
    public ResponseEntity<HttpStatus> deleteAllDoctors() {
        try {
            doctorRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}













