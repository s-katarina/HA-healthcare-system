package com.patientmedicalhistory.controller;

import com.patientmedicalhistory.dto.CreateMedicalRecordDTO;
import com.patientmedicalhistory.dto.GetMedicalRecordDTO;
import com.patientmedicalhistory.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/medicalrecords")
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordRetrievalService;

    @GetMapping(value="/{id}")
    ResponseEntity<GetMedicalRecordDTO> getById(@PathVariable UUID id) {
        return new ResponseEntity<>(medicalRecordRetrievalService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<GetMedicalRecordDTO>> getAll(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return new ResponseEntity<>(medicalRecordRetrievalService.getAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public GetMedicalRecordDTO save(@RequestBody CreateMedicalRecordDTO dto) {
        return medicalRecordRetrievalService.addMedicalRecord(dto);
    }

}
