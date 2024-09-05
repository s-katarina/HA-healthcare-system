package com.patientcoredata.service.impl;

import com.patientcoredata.dto.CreatePatientRecordDTO;
import com.patientcoredata.dto.GetPatientRecordDTO;
import com.patientcoredata.exception.PatientRecordWithPatientIdAlreadyExistsException;
import com.patientcoredata.exception.PatientRecordWithPatientIdNotFoundException;
import com.patientcoredata.mapper.PatientRecordMapper;
import com.patientcoredata.model.PatientRecord;
import com.patientcoredata.repository.PatientRecordRepository;
import com.patientcoredata.service.PatientRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PatientRecordServiceImpl implements PatientRecordService {

    private final PatientRecordRepository patientRecordRepository;
    private final PatientRecordMapper mapper;

    @Override
    public GetPatientRecordDTO getByPatientId(String patientId) {
        PatientRecord patientRecord = patientRecordRepository.findByPatientId(patientId).orElseThrow(
                () -> new PatientRecordWithPatientIdNotFoundException(patientId)
        );
        return mapper.mapToDTO(patientRecord);
    }

    @Override
    public List<GetPatientRecordDTO> getAll() {
        return patientRecordRepository.findAll().stream().map(mapper::mapToDTO).toList();
    }

    @Override
    public GetPatientRecordDTO add(CreatePatientRecordDTO dto) {
        if (patientRecordRepository.existsByPatientId(dto.getPatientId())) {
            throw new PatientRecordWithPatientIdAlreadyExistsException(dto.getPatientId());
        }
        PatientRecord patientRecord = mapper.mapCreateToPatientRecord(dto);
        patientRecordRepository.save(patientRecord);
        return mapper.mapToDTO(patientRecord);
    }
}
