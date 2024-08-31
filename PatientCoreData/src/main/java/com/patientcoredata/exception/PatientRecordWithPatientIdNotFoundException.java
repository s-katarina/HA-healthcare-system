package com.patientcoredata.exception;

public class PatientRecordWithPatientIdNotFoundException extends RuntimeException {
    public PatientRecordWithPatientIdNotFoundException(String patientId) {
        super("Patient with id " + patientId + " not found");
    }
}
