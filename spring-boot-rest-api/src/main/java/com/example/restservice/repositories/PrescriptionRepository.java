package com.example.restservice.repositories;

import com.example.restservice.models.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PrescriptionRepository extends MongoRepository<Prescription, String> {
    List<Prescription> findPrescriptionByRegistrationId(String id);
//    Optional<Prescription> findPrescriptionByRegistrationId
}
