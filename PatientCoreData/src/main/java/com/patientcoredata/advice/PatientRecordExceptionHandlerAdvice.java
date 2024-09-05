package com.patientcoredata.advice;

import com.patientcoredata.exception.BadDateFormatException;
import com.patientcoredata.exception.PatientRecordWithPatientIdAlreadyExistsException;
import com.patientcoredata.exception.PatientRecordWithPatientIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PatientRecordExceptionHandlerAdvice {

    @ExceptionHandler(PatientRecordWithPatientIdAlreadyExistsException.class)
    public ResponseEntity<String> handlePatientRecordWithPatientIdAlreadyExistsException(PatientRecordWithPatientIdAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PatientRecordWithPatientIdNotFoundException.class)
    public ResponseEntity<String> handlePatientRecordWithPatientIdNotFoundException(PatientRecordWithPatientIdNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadDateFormatException.class)
    public ResponseEntity<String> handleBadDateFormatException(BadDateFormatException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
