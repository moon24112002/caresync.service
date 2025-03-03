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
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
    private Long doctorId;
    private Long slotId; 

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id", referencedColumnName = "id")
    private Details details;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Disease> diseases;

}
