package com.patientcoredata.service;

import com.patientcoredata.dto.GetPatientRecordDTO;

import java.util.List;

public interface PatientRecordService {

    public GetPatientRecordDTO getByPatientId(String patientId);
    public List<GetPatientRecordDTO> getAll();

}
