package com.example.restservice.repositories;

import com.example.restservice.models.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PatientRepository extends MongoRepository<Patient, String> {
    Optional<Patient> findPatientByName(String name);
    Optional<Patient> findPatientByNameAndDateOfBirth(String name, String dateOfBirth);
}
