package com.patientcoredata.dto;

import com.patientcoredata.model.BloodType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePatientRecordDTO {

    @NotEmpty(message = "Patient Name is mandatory")
    private String name;
    @NotEmpty(message = "Patient Surname is mandatory")
    private String surname;
    @NotEmpty(message = "Patient Id is mandatory")
    private String patientId;
    @NotEmpty(message = "Patient Date of birth is mandatory")
    private String dateOfBirth;
    @NotNull(message = "Patient Blood type is mandatory")
    private BloodType bloodType;
    private float cmHeight;
    private float kgWeight;
    private String allergies;
    private String illnesses;

}
