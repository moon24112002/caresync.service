package com.CareSync.Repository;

import com.CareSync.Models.Patient;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
//    @EntityGraph(attributePaths = "diseases")
//    Optional<Patient> findById(Long id);
}
