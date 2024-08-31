package com.patientcoredata.mapper;

import com.patientcoredata.dto.CreatePatientRecordDTO;
import com.patientcoredata.dto.GetPatientRecordDTO;
import com.patientcoredata.model.PatientRecord;
import org.springframework.stereotype.Component;

@Component
public class PatientRecordMapper {

    public GetPatientRecordDTO mapToDTO(PatientRecord patientRecord) {
        GetPatientRecordDTO dto = new GetPatientRecordDTO();
        dto.setId(patientRecord.getId());
        dto.setName(patientRecord.getName());
        dto.setSurname(patientRecord.getSurname());
        dto.setDateOfBirth(patientRecord.getDateOfBirth());
        dto.setBloodType(patientRecord.getBloodType().toString());
        dto.setAllergies(patientRecord.getAllergies());
        dto.setIllnesses(patientRecord.getIllnesses());
        return dto;
    }

    public PatientRecord mapCreateToPatientRecord(CreatePatientRecordDTO dto) {
        PatientRecord patientRecord = new PatientRecord();
        patientRecord.setName(dto.getName());
        patientRecord.setSurname(dto.getSurname());
        patientRecord.setBloodType(dto.getBloodType());
        patientRecord.setAllergies(dto.getAllergies());
        patientRecord.setIllnesses(dto.getIllnesses());
        return patientRecord;
    }

}
