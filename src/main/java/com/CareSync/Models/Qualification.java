package com.CareSync.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctor_qualifications")
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String degree; // e.g., MBBS, MD, DO
    private String institution; // e.g., Harvard Medical School
    private String yearOfPassing; // e.g., 2015
    @ElementCollection
    @CollectionTable(name = "qualification", joinColumns = @JoinColumn(name = "qualification_id"))
    @Column(name = "specialization")
    private List<String> specialization; // e.g., Cardiology, Pediatrics
}
