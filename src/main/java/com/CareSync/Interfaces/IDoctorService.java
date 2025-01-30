package com.CareSync.Interfaces;

import com.CareSync.Models.ApiResponse;
import com.CareSync.Models.Doctor;
import org.springframework.http.ResponseEntity;

import javax.print.Doc;

public interface IDoctorService {
    public ResponseEntity<ApiResponse> addDoctor(Doctor doctor);
    public ResponseEntity<ApiResponse> DoctorById(Long id);
    public ResponseEntity<ApiResponse> getAllDoctor();

}
