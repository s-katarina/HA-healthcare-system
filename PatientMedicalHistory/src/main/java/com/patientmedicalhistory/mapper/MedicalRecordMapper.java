package com.patientmedicalhistory.mapper;

import com.patientmedicalhistory.dto.GetMedicalRecordDTO;
import com.patientmedicalhistory.model.MedicalRecord;
import org.springframework.stereotype.Component;

@Component
public class MedicalRecordMapper {

    public GetMedicalRecordDTO mapToDTO(MedicalRecord medicalRecord) {
        GetMedicalRecordDTO dto = new GetMedicalRecordDTO();
        dto.setId(medicalRecord.getId());
        dto.setContent(medicalRecord.getContent());
        return dto;
    }

}
