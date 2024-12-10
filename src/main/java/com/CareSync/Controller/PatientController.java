package com.CareSync.Controller;

import com.CareSync.Interfaces.IPatientService;
import com.CareSync.Models.Patient;
import com.CareSync.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    IPatientService _patientService;

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient){
        return _patientService.addPatient(patient);
    }

    @GetMapping("/{id}")
    public Patient patientById(@PathVariable Long id){
       return  _patientService.PatientById(id);
    }

    @GetMapping
    public Iterable<Patient> getAllPatient(){
        return _patientService.getAllPatient();
    }


}
