package com.CareSync.Interfaces;

import com.CareSync.Models.ApiResponse;
import com.CareSync.Models.Patient;
import org.springframework.http.ResponseEntity;

public interface IPatientService {
    public ResponseEntity<ApiResponse> addPatient(Patient patient);
    public ResponseEntity<ApiResponse> PatientById(Long id);
    public ResponseEntity<ApiResponse> getAllPatient();
}
