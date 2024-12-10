package com.CareSync.Controller;

import com.CareSync.Models.Patient;
import com.CareSync.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientRepository patientRepository;

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }

    @GetMapping
    public Iterable<Patient> getAllPatient(){
        return patientRepository.findAll();
    }


}
