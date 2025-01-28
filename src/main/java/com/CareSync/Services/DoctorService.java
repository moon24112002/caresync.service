package com.CareSync.Services;


import com.CareSync.Interfaces.IDoctorService;
import com.CareSync.Models.Doctor;
import com.CareSync.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService  implements IDoctorService {

    @Autowired
    DoctorRepository _doctorRepository;


    @Override
    public Doctor addDoctor(Doctor doctor) {
        return _doctorRepository.save(doctor);
    }

    @Override
    public Doctor DoctorById(Long id) {
        Optional<Doctor> doctor = _doctorRepository.findById(id);
        if(doctor.isPresent()) return doctor.get();
        return null;
    }

    @Override
    public Iterable<Doctor> getAllDoctor() {
        return _doctorRepository.findAll();
    }
}
