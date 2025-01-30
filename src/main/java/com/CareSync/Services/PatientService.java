package com.CareSync.Services;

import com.CareSync.Interfaces.IPatientService;
import com.CareSync.Models.ApiResponse;
import com.CareSync.Models.Patient;
import com.CareSync.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService implements IPatientService {

    @Autowired
    PatientRepository _patientRepository;


    @Override
    public ResponseEntity<ApiResponse> addPatient(Patient patient) {
        if (patient.getDiseases() != null) {
            patient.getDiseases().forEach(disease -> disease.setPatient(patient));
        }
       var res =  _patientRepository.save(patient);
        return ResponseEntity.ok(new ApiResponse("success",res));
    }

    @Override
    public ResponseEntity<ApiResponse> PatientById(Long id) {
       Optional<Patient> patient =  _patientRepository.findById(id);
       if(patient.isPresent()){
           return ResponseEntity.ok(new ApiResponse("success",patient.get()));
       }
       return  null;
    }

    @Override
    public ResponseEntity<ApiResponse> getAllPatient() {
        var res =  _patientRepository.findAll();
        return ResponseEntity.ok(new ApiResponse("Success",res));
    }
}
