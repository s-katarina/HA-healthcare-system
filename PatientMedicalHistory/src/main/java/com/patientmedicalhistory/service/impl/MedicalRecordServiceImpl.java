package com.patientmedicalhistory.service.impl;

import com.patientmedicalhistory.dto.CreateMedicalRecordDTO;
import com.patientmedicalhistory.dto.GetMedicalRecordDTO;
import com.patientmedicalhistory.exception.MedicalRecordDoesNotExistsException;
import com.patientmedicalhistory.mapper.MedicalRecordMapper;
import com.patientmedicalhistory.model.MedicalRecord;
import com.patientmedicalhistory.repository.MedicalRecordRepository;
import com.patientmedicalhistory.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final MedicalRecordMapper mapper;
    private final MedicalRecordRepository medicalRecordRepository;

    @Override
    public GetMedicalRecordDTO getById(UUID id) {
        MedicalRecord medicalRecord =  medicalRecordRepository.findById(id).orElseThrow(
                () -> new MedicalRecordDoesNotExistsException(id));
        return mapper.mapToDTO(medicalRecord);
    }

    @Override
    public List<GetMedicalRecordDTO> getByPatientId(String patientId) {
        return List.of();
    }

    @Override
    public List<GetMedicalRecordDTO> getAll(Pageable pageable) {
        return medicalRecordRepository.findAll(pageable)
                .stream()
                .map(mapper::mapToDTO)
                .toList();
    }

    @Override
    public GetMedicalRecordDTO addMedicalRecord(CreateMedicalRecordDTO dto) {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setPatientId(dto.getPatientId());
        medicalRecord.setContent(dto.getContent());
        return mapper.mapToDTO(medicalRecordRepository.save(medicalRecord));
    }
}
