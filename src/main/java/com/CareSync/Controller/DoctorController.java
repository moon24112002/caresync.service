package com.CareSync.Controller;

import com.CareSync.Interfaces.IDoctorService;
import com.CareSync.Models.*;
import com.CareSync.Models.Qualification;
import com.CareSync.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    IDoctorService _doctorService;

    @PostMapping
    public ResponseEntity<ApiResponse> addDoctor(@RequestBody Doctor doctor){
       return _doctorService.addDoctor(doctor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> doctorById(@PathVariable Long id){
        return _doctorService.DoctorById(id);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllDoctor(){
        return _doctorService.getAllDoctor();
    }


}
