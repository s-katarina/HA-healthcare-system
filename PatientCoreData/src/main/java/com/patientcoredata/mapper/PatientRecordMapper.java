package com.patientcoredata.mapper;

import com.patientcoredata.dto.CreatePatientRecordDTO;
import com.patientcoredata.dto.GetPatientRecordDTO;
import com.patientcoredata.exception.BadDateFormatException;
import com.patientcoredata.model.PatientRecord;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;

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
        try {
            LocalDateTime.parse(dto.getDateOfBirth());
        } catch (DateTimeParseException e) {
            throw new BadDateFormatException();
        }
        PatientRecord patientRecord = new PatientRecord();
        patientRecord.setName(dto.getName());
        patientRecord.setSurname(dto.getSurname());
        patientRecord.setBloodType(dto.getBloodType());
        patientRecord.setAllergies(dto.getAllergies());
        patientRecord.setIllnesses(dto.getIllnesses());
        patientRecord.setPatientId(dto.getPatientId());
        patientRecord.setKgWeight(dto.getKgWeight());
        patientRecord.setCmHeight(dto.getCmHeight());
        patientRecord.setDateOfBirth(LocalDateTime.parse(dto.getDateOfBirth()));
        return patientRecord;
    }

}
