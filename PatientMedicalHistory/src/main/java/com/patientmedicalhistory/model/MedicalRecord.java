package com.patientmedicalhistory.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "medicalrecords")
@Setter
@Getter
@AllArgsConstructor
public class MedicalRecord {

    @Id
    private UUID id;
    private String content;
    private String patientId;
    private LocalDateTime dateCreated;

    public MedicalRecord() {
        this.id = UUID.randomUUID();
        this.dateCreated = LocalDateTime.now();
    }
}