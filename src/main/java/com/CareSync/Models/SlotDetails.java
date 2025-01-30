package com.CareSync.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "slot_details") // Changed table name for clarity
public class SlotDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false) // Ensures doctorId is unique
    private Long doctorId;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private int slotTime; // in minutes

    @OneToMany(mappedBy = "slotDetails", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Slots> slots = new ArrayList<>(); // Initialize to prevent NullPointerException

    // Helper method to add slot
    public void addSlot(Slots slot) {
        slot.setSlotDetails(this); // Ensure bidirectional consistency
        slots.add(slot);
    }
}
