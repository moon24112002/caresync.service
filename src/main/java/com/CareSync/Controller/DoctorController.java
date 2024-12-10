package com.CareSync.Controller;

import com.CareSync.Models.*;
import com.CareSync.Models.Qualification;
import com.CareSync.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor){
       return doctorRepository.save(doctor);
    }

    @GetMapping
    public Iterable<Doctor> getAllDoctor(){
        return doctorRepository.findAll();
    }


}
