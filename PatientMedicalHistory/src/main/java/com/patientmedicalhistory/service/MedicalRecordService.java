package com.patientmedicalhistory.service;

import com.patientmedicalhistory.dto.CreateMedicalRecordDTO;
import com.patientmedicalhistory.dto.GetMedicalRecordDTO;
import com.patientmedicalhistory.model.MedicalRecord;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface MedicalRecordService {

    GetMedicalRecordDTO getById(UUID id);

    List<GetMedicalRecordDTO> getByPatientId(String patientId);

    List<GetMedicalRecordDTO> getAll(Pageable pageable);

    GetMedicalRecordDTO addMedicalRecord(CreateMedicalRecordDTO medicalRecord);

}
