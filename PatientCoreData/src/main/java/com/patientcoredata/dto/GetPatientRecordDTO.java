package com.patientcoredata.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetPatientRecordDTO {

    private UUID id;
    private String name;
    private String surname;
    private LocalDateTime dateOfBirth;
    private String bloodType;
    private float cmHeight;
    private float kgWeight;
    private String allergies;
    private String illnesses;

}
