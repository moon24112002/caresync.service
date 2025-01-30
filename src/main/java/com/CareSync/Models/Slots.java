package com.CareSync.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "slots") // Plural table name for clarity
public class Slots {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime startAt;
    private LocalTime endAt;

    @ManyToOne
    @JoinColumn(name = "slot_details_id", referencedColumnName = "id") // Foreign Key reference
    @JsonBackReference
    private SlotDetails slotDetails;
}
