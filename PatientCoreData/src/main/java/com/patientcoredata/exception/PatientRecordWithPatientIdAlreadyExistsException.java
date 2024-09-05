package com.patientcoredata.exception;

public class PatientRecordWithPatientIdAlreadyExistsException extends RuntimeException {
    public PatientRecordWithPatientIdAlreadyExistsException(String patientId) {
        super("Patient Record with Patient Id id " + patientId + " already exists");
    }
}
