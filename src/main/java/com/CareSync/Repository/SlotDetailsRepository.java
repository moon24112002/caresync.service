package com.CareSync.Repository;

import com.CareSync.Models.SlotDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SlotDetailsRepository extends JpaRepository<SlotDetails, Long> {
   @Query("SELECT s FROM SlotDetails s WHERE s.doctorId = :doctorId")
   SlotDetails findSlotsByDoctorId(@Param("doctorId") Long doctorId);
}
