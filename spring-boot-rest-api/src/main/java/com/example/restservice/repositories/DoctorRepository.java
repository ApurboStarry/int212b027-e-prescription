package com.example.restservice.repositories;

import com.example.restservice.models.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
    Optional<Doctor> findDoctorByDoctorName(String name);
}