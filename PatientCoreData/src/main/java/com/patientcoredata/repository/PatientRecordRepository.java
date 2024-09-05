package com.patientcoredata.repository;

import com.patientcoredata.model.PatientRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PatientRecordRepository extends JpaRepository<PatientRecord, UUID> {

    Optional<PatientRecord> findByPatientId(String patientId);
    boolean existsByPatientId(String patientId);

}
