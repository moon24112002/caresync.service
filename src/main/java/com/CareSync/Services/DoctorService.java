package com.CareSync.Services;


import com.CareSync.Interfaces.IDoctorService;
import com.CareSync.Models.ApiResponse;
import com.CareSync.Models.Doctor;
import com.CareSync.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import java.util.Optional;

@Service
public class DoctorService  implements IDoctorService {

    @Autowired
    DoctorRepository _doctorRepository;


    @Override
    public ResponseEntity<ApiResponse> addDoctor(Doctor doctor) {
        var res = _doctorRepository.save(doctor);
        return ResponseEntity.ok(new ApiResponse("success",res));
    }

    @Override
    public ResponseEntity<ApiResponse> DoctorById(Long id) {
        Optional<Doctor> doctor = _doctorRepository.findById(id);
        if(doctor.isPresent()) return ResponseEntity.ok(new ApiResponse("success",doctor));
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse> getAllDoctor() {
        var res =  _doctorRepository.findAll();
        return ResponseEntity.ok(new ApiResponse("success",res));
    }
}
