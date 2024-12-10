package com.CareSync.Interfaces;

import com.CareSync.Models.Patient;

public interface IPatientService {
    public Patient addPatient(Patient patient);
    public Patient PatientById(Long id);
    public Iterable<Patient> getAllPatient();
}
