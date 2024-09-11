package com.patientmedicalhistory.repository;

import com.patientmedicalhistory.model.MedicalRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface MedicalRecordRepository extends MongoRepository<MedicalRecord, UUID> {

    List<MedicalRecord> findByPatientId(String patientId);

}