package com.patientmedicalhistory.exception;

import java.util.UUID;

public class MedicalRecordDoesNotExistsException extends RuntimeException {

    public MedicalRecordDoesNotExistsException(UUID id) {
        super(String.format("Medical record with id %s does not exist", id.toString()));
    }

}