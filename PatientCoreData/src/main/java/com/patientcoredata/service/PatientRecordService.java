package com.patientcoredata.service;

import com.patientcoredata.dto.CreatePatientRecordDTO;
import com.patientcoredata.dto.GetPatientRecordDTO;

import java.util.List;

public interface PatientRecordService {

    GetPatientRecordDTO getByPatientId(String patientId);
    List<GetPatientRecordDTO> getAll();
    GetPatientRecordDTO add(CreatePatientRecordDTO dto);

}
