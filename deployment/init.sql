CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE patient_records (
                                 id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                                 patient_name VARCHAR(50) NOT NULL,
                                 patient_surname VARCHAR(50) NOT NULL,
                                 patient_id VARCHAR(255) NOT NULL UNIQUE,
                                 date_of_birth TIMESTAMP,
                                 blood_type VARCHAR(20),
                                 cm_height FLOAT CHECK (cm_height >= 0 AND cm_height <= 300),
                                 kg_weight FLOAT CHECK (kg_weight >= 0 AND kg_weight <= 1000),
                                 allergies TEXT,
                                 illnesses TEXT
);
