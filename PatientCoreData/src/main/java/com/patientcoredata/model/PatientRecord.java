package com.patientcoredata.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "patient_records")
public class PatientRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="patient_name", length=50, nullable=false)
    private String name;

    @Column(name="patient_surname", length=50, nullable=false)
    private String surname;

    @Column(name="patient_id", nullable=false, unique = true)
    private String patientId;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;

    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    @Column(name = "cm_height")
    @Min(value = 0, message = "Height must be at least 0 cm")
    @Max(value = 300, message = "Height cannot be more than 300 cm")
    private float cmHeight;

    @Column(name = "kg_weight")
    @Min(value = 0, message = "Weight must be at least 0 kg")
    @Max(value = 1000, message = "Weight cannot be more than 1000 kg")
    private float kgWeight;

    @Column(name="allergies")
    private String allergies;

    @Column(name="illnesses")
    private String illnesses;

}
