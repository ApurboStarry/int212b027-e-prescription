package com.example.restservice.repositories;

import com.example.restservice.models.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface HospitalRepository extends MongoRepository<Hospital, String> {
    List<Hospital> findHospitalsByHospitalNameEquals(String name);
    Optional<Hospital> findHospitalByHospitalName(String name);
}
