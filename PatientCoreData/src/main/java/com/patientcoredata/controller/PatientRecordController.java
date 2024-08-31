package com.patientcoredata.controller;

import com.patientcoredata.dto.GetPatientRecordDTO;
import com.patientcoredata.service.PatientRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/patientrecords")
public class PatientRecordController {

    private final PatientRecordService patientRecordService;

    @GetMapping
    ResponseEntity<GetPatientRecordDTO> getByPatientId(@RequestParam String patientId) {
        return new ResponseEntity<>(patientRecordService.getByPatientId(patientId), HttpStatus.OK);
    }

    @GetMapping("/all")
    ResponseEntity<List<GetPatientRecordDTO>> getAllPatientRecords() {
        return new ResponseEntity<>(patientRecordService.getAll(), HttpStatus.OK);
    }
}
