package com.CareSync.Services;

import com.CareSync.Interfaces.IPatientService;
import com.CareSync.Models.Patient;
import com.CareSync.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService implements IPatientService {

    @Autowired
    PatientRepository _patientRepository;


    @Override
    public Patient addPatient(Patient patient) {
        if (patient.getDiseases() != null) {
            patient.getDiseases().forEach(disease -> disease.setPatient(patient));
        }
       return  _patientRepository.save(patient);
    }

    @Override
    public Patient PatientById(Long id) {
       Optional<Patient> patient =  _patientRepository.findById(id);
       if(patient.isPresent()){
           return patient.get();
       }
       return  null;
    }

    @Override
    public Iterable<Patient> getAllPatient() {
        return _patientRepository.findAll();
    }
}
