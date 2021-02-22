package com.example.restservice.controllers;

import com.example.restservice.models.Hospital;
import com.example.restservice.repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HospitalController {
    @Autowired
    private HospitalRepository hospitalRepository;

    @GetMapping("/hospitals")
    public ResponseEntity<List<Hospital>> getAllHospitals() {
        List<Hospital> hospitalList = new ArrayList<>();
        hospitalRepository.findAll().forEach(hospitalList::add);

        return new ResponseEntity<>(hospitalList, HttpStatus.OK);
    }

    @GetMapping("/hospitals/id/{id}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable("id") String id) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);

        if(hospital.isPresent()) {
            return new ResponseEntity<>(hospital.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/hospitals/name/{name}")
    public ResponseEntity<Hospital> getHospitalByName(@PathVariable String name) {
        Optional<Hospital> hospitalData = hospitalRepository.findHospitalByHospitalName(name);

        if(hospitalData.isPresent()) {
            return new ResponseEntity<>(hospitalData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/hospitals", params = "hospitalName", method = RequestMethod.GET)
    public ResponseEntity<List<Hospital>> getHospitalsByName(@RequestParam("hospitalName") String hospitalName) {
        List<Hospital> hospitalList = hospitalRepository.findHospitalsByHospitalNameEquals(hospitalName);

        if(hospitalList.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(hospitalList, HttpStatus.OK);
        }
    }

    @PostMapping("/hospitals")
    public ResponseEntity<Hospital> createHospital(@RequestBody Hospital hospital) {
        try {
            Hospital _hospital = hospitalRepository.save(hospital);
            return new ResponseEntity<>(_hospital, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/hospitals/{id}")
    public ResponseEntity<Hospital> updateHospital(@PathVariable("id") String id, @RequestBody Hospital hospital) {
        Optional<Hospital> hospitalData = hospitalRepository.findById(id);

        if(hospitalData.isPresent()) {
            Hospital _hospital = hospitalData.get();
            _hospital.setHospitalName(hospital.getHospitalName());
            _hospital.setBranchName(hospital.getBranchName());
            _hospital.setAddress(hospital.getAddress());
            _hospital.setContactNumber(hospital.getContactNumber());
            _hospital.setEmail(hospital.getEmail());

            return new ResponseEntity<>(hospitalRepository.save(_hospital), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/hospitals/{id}")
    public ResponseEntity<HttpStatus> deleteHospital(@PathVariable("id") String id) {
        try {
            hospitalRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/hospitals")
    public ResponseEntity<HttpStatus> deleteAllHospitals() {
        try {
            hospitalRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
