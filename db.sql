CREATE DATABASE hospital_patient_service;

USE hospital_patient_service;

CREATE TABLE patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    dob DATE,
    gender ENUM('M', 'F', 'Other'),
    contact_number VARCHAR(15),
    email VARCHAR(100),
    address VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE DATABASE hospital_doctor_service;

USE hospital_doctor_service;

CREATE TABLE doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    specialty VARCHAR(100),
    contact_number VARCHAR(15),
    email VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE DATABASE hospital_appointment_service;

USE hospital_appointment_service;

CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    appointment_time TIME,
    status ENUM('Scheduled', 'Completed', 'Cancelled'),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (patient_id) REFERENCES hospital_patient_service.patients(id),
    FOREIGN KEY (doctor_id) REFERENCES hospital_doctor_service.doctors(id)
);


CREATE DATABASE hospital_billing_service;

USE hospital_billing_service;

CREATE TABLE bills (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    amount DECIMAL(10, 2),
    billing_date DATE,
    payment_status ENUM('Paid', 'Unpaid'),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (patient_id) REFERENCES hospital_patient_service.patients(id)
);


CREATE DATABASE hospital_medical_records_service;

USE hospital_medical_records_service;

CREATE TABLE medical_records (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    diagnosis TEXT,
    treatment TEXT,
    record_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (patient_id) REFERENCES hospital_patient_service.patients(id),
    FOREIGN KEY (doctor_id) REFERENCES hospital_doctor_service.doctors(id)
);


CREATE DATABASE hospital_inventory_service;

USE hospital_inventory_service;

CREATE TABLE inventory (
    id INT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(100),
    quantity INT,
    category VARCHAR(50),
    purchase_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- Insert Data --


-- Patient Service Database
USE hospital_patient_service;

INSERT INTO patients (first_name, last_name, dob, gender, contact_number, email, address)
VALUES 
('John', 'Doe', '1985-05-15', 'M', '1234567890', 'john.doe@example.com', '1234 Elm Street'),
('Jane', 'Smith', '1990-08-20', 'F', '0987654321', 'jane.smith@example.com', '5678 Oak Avenue'),
('Jim', 'Beam', '1978-12-30', 'M', '1122334455', 'jim.beam@example.com', '9101 Pine Road'),
('Mary', 'Johnson', '2000-03-10', 'F', '6677889900', 'mary.johnson@example.com', '1213 Maple Lane');

-- Doctor Service Database
USE hospital_doctor_service;

INSERT INTO doctors (first_name, last_name, specialty, contact_number, email)
VALUES 
('Alice', 'Brown', 'Cardiology', '2345678901', 'alice.brown@example.com'),
('Robert', 'Davis', 'Neurology', '3456789012', 'robert.davis@example.com'),
('Emily', 'Wilson', 'Orthopedics', '4567890123', 'emily.wilson@example.com'),
('David', 'Moore', 'Pediatrics', '5678901234', 'david.moore@example.com');

-- Appointment Service Database
USE hospital_appointment_service;

INSERT INTO appointments (patient_id, doctor_id, appointment_date, appointment_time, status)
VALUES 
(1, 1, '2024-06-10', '09:00:00', 'Scheduled'),
(2, 2, '2024-06-11', '10:00:00', 'Scheduled'),
(3, 3, '2024-06-12', '11:00:00', 'Completed'),
(4, 4, '2024-06-13', '12:00:00', 'Cancelled');

-- Billing Service Database
USE hospital_billing_service;

INSERT INTO bills (patient_id, amount, billing_date, payment_status)
VALUES 
(1, 1500.00, '2024-06-10', 'Paid'),
(2, 2000.00, '2024-06-11', 'Unpaid'),
(3, 1800.00, '2024-06-12', 'Paid'),
(4, 2200.00, '2024-06-13', 'Unpaid');

-- Medical Records Service Database
USE hospital_medical_records_service;

INSERT INTO medical_records (patient_id, doctor_id, diagnosis, treatment, record_date)
VALUES 
(1, 1, 'Hypertension', 'Lifestyle changes, medication', '2024-06-10'),
(2, 2, 'Migraine', 'Pain relief medication', '2024-06-11'),
(3, 3, 'Fractured Arm', 'Cast, physical therapy', '2024-06-12'),
(4, 4, 'Bronchitis', 'Antibiotics, rest', '2024-06-13');

-- Inventory Service Database
USE hospital_inventory_service;

INSERT INTO inventory (item_name, quantity, category, purchase_date)
VALUES 
('Aspirin', 100, 'Medicine', '2024-06-01'),
('Stethoscope', 20, 'Equipment', '2024-06-02'),
('Bandages', 200, 'Supplies', '2024-06-03'),
('Antibiotics', 150, 'Medicine', '2024-06-04');
