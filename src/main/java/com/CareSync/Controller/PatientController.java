package com.CareSync.Controller;

import com.CareSync.Interfaces.IPatientService;
import com.CareSync.Models.ApiResponse;
import com.CareSync.Models.Patient;
import com.CareSync.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    IPatientService _patientService;

    @PostMapping
    public ResponseEntity<ApiResponse> addPatient(@RequestBody Patient patient){
        return _patientService.addPatient(patient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> patientById(@PathVariable Long id){
       return  _patientService.PatientById(id);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllPatient(){
        return _patientService.getAllPatient();
    }


}
