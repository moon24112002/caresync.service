package com.CareSync.Interfaces;

import com.CareSync.Models.Doctor;

import javax.print.Doc;

public interface IDoctorService {
    public Doctor addDoctor(Doctor doctor);
    public Doctor DoctorById(Long id);
    public Iterable<Doctor> getAllDoctor();

}
